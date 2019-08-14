package com.abid.confiados.activity

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.util.Log.e
import android.view.LayoutInflater
import android.view.View
import android.webkit.MimeTypeMap
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import com.abid.confiados.data.Pref
import com.abid.confiados.R
import com.abid.confiados.adapter.CountryAdapter
import com.abid.confiados.model.CountryModel
import com.abid.confiados.model.DestinationModel
import com.abid.confiados.utils.ApiClient
import com.abid.confiados.utils.ApiInterface
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import kotlinx.android.synthetic.main.activity_upload.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException
import java.util.*
import kotlin.collections.ArrayList

class UploadActivity : AppCompatActivity() {
    lateinit var pref: Pref
    var value = 0.0
    val REQUEST_CODE_IMAGE = 10002
    val PERMISSION_RC = 10003
    lateinit var filePathImage: Uri
    lateinit var dbRef: DatabaseReference
    lateinit var firebaseStorage: FirebaseStorage
    lateinit var storageReference: StorageReference
    lateinit var fAuth: FirebaseAuth
    lateinit var destinationModel: DestinationModel
    var dataxxx: String? = null
    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload)
        setSupportActionBar(toolbarUpload)
        supportActionBar!!.title = "UPLOAD DESTINATION"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        destinationModel = DestinationModel()
        fAuth = FirebaseAuth.getInstance()
        pref = Pref(this)
        firebaseStorage = FirebaseStorage.getInstance()
        storageReference = firebaseStorage.reference
        linearDestination.setOnClickListener {
            showDialogCountry()
        }

        imagePHolder.setOnClickListener {
            when {
                (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) -> {
                    if (ContextCompat.checkSelfPermission(
                            this,
                            Manifest.permission.READ_EXTERNAL_STORAGE
                        )
                        != PackageManager.PERMISSION_GRANTED
                    ) {
                        requestPermissions(
                            arrayOf(
                                Manifest.permission.READ_EXTERNAL_STORAGE
                            ), PERMISSION_RC
                        )
                    } else {
                        imageChooser()
                    }
                }
                else -> {
                    imageChooser()
                }
            }
        }

        counter = pref.getCounterId()

        dataxxx = this.intent.getStringExtra("kode")
        if (dataxxx != null) {
//            showDataFromDB()
            counter = dataxxx!!.toInt()
        }

        btnUploadDestination.setOnClickListener {
            val destination = uploadDestination.text.toString()
            val startDate = startDateUpload.text.toString()
            val endDate = endDateUpload.text.toString()

            if (destination.isNotEmpty() || startDate.isNotEmpty() ||
                endDate.isNotEmpty()
            ) {
                addToFirebase(destination, startDate, endDate)
                if (dataxxx == null) {
                    pref.saveCounterId(counter + 1)
                }
            } else {
                Toast.makeText(
                    this,
                    "Fill Data",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun imageChooser() {
        val intent = Intent().apply {
            type = "image/*"
            action = Intent.ACTION_GET_CONTENT
        }
        startActivityForResult(
            Intent.createChooser(intent, "Select Image"),
            REQUEST_CODE_IMAGE
        )
    }

    private fun addToFirebase(destination: String, startDate: String, endDate: String) {
        val nameXXX = UUID.randomUUID().toString()
        val iddest = pref.getCounterId()
        val uid = fAuth.currentUser?.uid
        val storageRef: StorageReference = storageReference
            .child("images/$uid/$nameXXX.${GetFileExtension(filePathImage)}")
        storageRef.putFile(filePathImage).addOnSuccessListener {
            storageRef.downloadUrl.addOnSuccessListener {
                dbRef = FirebaseDatabase.getInstance().getReference("destination/$iddest")
                dbRef.child("bukti").setValue(it.toString())
                dbRef.child("destination").setValue(destination)
                dbRef.child("startDate").setValue(startDate)
                dbRef.child("endDate").setValue(endDate)
                FirebaseDatabase.getInstance().getReference("dataUser/")
                    .child("${fAuth.uid}/id")
                    .addListenerForSingleValueEvent(
                        object : ValueEventListener {
                            override fun onDataChange(p0: DataSnapshot) {
                                dbRef.child("iduser").setValue(p0.value)
                            }

                            override fun onCancelled(p0: DatabaseError) {
                                Log.e("Error", p0.message)
                            }

                        })
            }
            Toast.makeText(
                this,
                "Success Upload",
                Toast.LENGTH_SHORT
            ).show()
            progressDownload.visibility = View.GONE
        }.addOnFailureListener {
            Log.e("TAG_ERROR", it.message)
        }.addOnProgressListener { taskSnapshot ->
            value = (100.0 * taskSnapshot
                .bytesTransferred / taskSnapshot.totalByteCount)
            progressDownload.visibility = View.VISIBLE
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            PERMISSION_RC -> {
                if (grantResults.isEmpty() ||
                    grantResults[0] == PackageManager.PERMISSION_DENIED
                ) {
                    Toast.makeText(
                        this,
                        "Ditolak",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    imageChooser()
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode != Activity.RESULT_OK) {
            return
        }
        when (requestCode) {
            REQUEST_CODE_IMAGE -> {
                filePathImage = data?.data!!
                try {
                    val bitmap: Bitmap = MediaStore
                        .Images.Media.getBitmap(
                        this.contentResolver, filePathImage
                    )
                    Glide.with(this).load(bitmap)
                        .override(250, 250)
                        .centerCrop().into(imagePHolder)
                } catch (x: IOException) {
                    x.printStackTrace()
                }
            }
        }
    }

    fun GetFileExtension(uri: Uri): String? {
        val contentResolver = this.contentResolver
        val mimeTypeMap = MimeTypeMap.getSingleton()
        return mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(uri))
    }

    fun showDialogCountry(){
        var dialog : AlertDialog
        val builder = AlertDialog.Builder(this)
        val view = LayoutInflater.from(this).inflate(R.layout.popup_countries, null)

        builder.setView(view)
        val searchCountry : EditText = view.findViewById(R.id.searchCountry)
        val listCountry : ListView = view.findViewById(R.id.listCountry)
        getCountry(listCountry)
        searchCountry.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s!!.isNotEmpty()) {
                    getCountry(listCountry, s.toString())
                } else {
                    getCountry(listCountry)
                }
            }

        })
        dialog = builder.create()
        dialog.show()
        listCountry.setOnItemClickListener { parent, view, position, id ->
            val country = parent.adapter.getItem(position) as CountryModel
            uploadDestination.text = country.name
            dialog.dismiss()
        }

    }

    fun getCountry(listCountry : ListView) {
        val apiInterface = ApiClient().getClient().create(ApiInterface::class.java)
        apiInterface.getCountry().enqueue(object : Callback<ArrayList<CountryModel>> {
            override fun onResponse(call: Call<ArrayList<CountryModel>>, response: Response<ArrayList<CountryModel>>) {
                if (response.code() == 200) {
                    listCountry.adapter = CountryAdapter(response.body()!!,this@UploadActivity)
                } else {
                    Toast.makeText(this@UploadActivity, "Gagal", Toast.LENGTH_SHORT).show()
                    e("without search", "error ${response.code()}")
                }
            }

            override fun onFailure(call: Call<ArrayList<CountryModel>>, t: Throwable) {
                Toast.makeText(this@UploadActivity, "Gagal", Toast.LENGTH_SHORT).show()
                e("without search", "error", t)
            }

        })
    }

    fun getCountry(listCountry: ListView, name : String) {
        val apiInterface = ApiClient().getClient().create(ApiInterface::class.java)
        apiInterface.getCountry(name).enqueue(object : Callback<ArrayList<CountryModel>> {
            override fun onResponse(call: Call<ArrayList<CountryModel>>, response: Response<ArrayList<CountryModel>>) {
                if (response.code() == 200) {
                    listCountry.adapter = CountryAdapter(response.body()!!,this@UploadActivity)
                } else {
                    Toast.makeText(this@UploadActivity, "Gagal", Toast.LENGTH_SHORT).show()
                    e("with search", "error ${response.code()}")
                }
            }

            override fun onFailure(call: Call<ArrayList<CountryModel>>, t: Throwable) {
                Toast.makeText(this@UploadActivity, "Gagal", Toast.LENGTH_SHORT).show()
                e("with search", "error", t)
            }

        })
    }
}
