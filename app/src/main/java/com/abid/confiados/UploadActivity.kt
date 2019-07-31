package com.abid.confiados

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.webkit.MimeTypeMap
import android.widget.Toast
import com.abid.confiados.model.DestinationModel
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import kotlinx.android.synthetic.main.fragment_upload.*
import java.io.IOException
import java.util.*

class UploadActivity : AppCompatActivity() {
    lateinit var pref: Preferences
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
        destinationModel = DestinationModel()
        fAuth = FirebaseAuth.getInstance()
        pref = Preferences(this)
        firebaseStorage = FirebaseStorage.getInstance()
        storageReference = firebaseStorage.reference
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
        val uid = pref.getUID()

        val storageRef: StorageReference = storageReference
            .child("images/$uid/$nameXXX.${GetFileExtension(filePathImage)}")
        storageRef.putFile(filePathImage).addOnSuccessListener {
            storageRef.downloadUrl.addOnSuccessListener {
                dbRef = FirebaseDatabase.getInstance().getReference("destination/$counter")
                dbRef.child("iduser").setValue(uid)
                dbRef.child("bukti").setValue(it.toString())
                dbRef.child("destination").setValue(destination)
                dbRef.child("startDate").setValue(startDate)
                dbRef.child("endDate").setValue(endDate)
                FirebaseDatabase.getInstance().getReference("dataUser/")
                    .child("${fAuth.uid}/nama")
                    .addListenerForSingleValueEvent(
                        object : ValueEventListener {
                            override fun onDataChange(p0: DataSnapshot) {
                                dbRef.child("name").setValue(p0.value)
                            }

                            override fun onCancelled(p0: DatabaseError) {
                                Log.e("Error", p0.message)
                            }

                        })
                FirebaseDatabase.getInstance().getReference("dataUser/")
                    .child("${fAuth.uid}/profile")
                    .addListenerForSingleValueEvent(
                        object : ValueEventListener {
                            override fun onDataChange(p0: DataSnapshot) {
                                dbRef.child("image").setValue(p0.value)
                            }

                            override fun onCancelled(p0: DatabaseError) {
                                Log.e("Error", p0.message)
                            }

                        })
                FirebaseDatabase.getInstance().getReference("dataUser/")
                    .child("${fAuth.uid}/gender")
                    .addListenerForSingleValueEvent(
                        object : ValueEventListener {
                            override fun onDataChange(p0: DataSnapshot) {
                                dbRef.child("gender").setValue(p0.value)
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
}
