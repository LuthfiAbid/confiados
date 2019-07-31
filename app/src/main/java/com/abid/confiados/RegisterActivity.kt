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
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import kotlinx.android.synthetic.main.activity_register.*
import java.io.IOException
import java.util.*

class RegisterActivity : AppCompatActivity() {
    var value = 0.0
    val REQUEST_CODE_IMAGE = 10002
    val PERMISSION_RC = 10003
    lateinit var fAuth: FirebaseAuth
    lateinit var dbRef: DatabaseReference
    lateinit var helperPref: Preferences
    lateinit var storageReference: StorageReference
    lateinit var firebaseStorage: FirebaseStorage
    lateinit var filePathImage: Uri


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        fAuth = FirebaseAuth.getInstance()
        helperPref = Preferences(this)
        firebaseStorage = FirebaseStorage.getInstance()
        storageReference = firebaseStorage.reference
        tv_login.setOnClickListener {
            Intent(this, LoginActivity::class.java)
        }

        submit.setOnClickListener {
            var name = et_name.text.toString()
            var phone = et_phone.text.toString()
            var spinner = sp_gender.selectedItem.toString()
            var email = et_email.text.toString()
            var password = et_password.text.toString()
            if (name.isNotEmpty() || phone.isNotEmpty() || email.isNotEmpty() || password.isNotEmpty()
            ) {
                fAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                            simpanToFirebase(name, email, password, spinner, phone)
                            Toast.makeText(this, "Register Berhasil!", Toast.LENGTH_SHORT).show()
                            onBackPressed()
                        } else {
                            Toast.makeText(this, "Value must be 6 or more digit!", Toast.LENGTH_SHORT).show()
                        }
                    }
            } else {
                Toast.makeText(this, "There's some empty input!", Toast.LENGTH_SHORT).show()
            }
        }
        imageProfileHolder.setOnClickListener {
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
                        .centerCrop().into(imageProfileHolder)
                } catch (x: IOException) {
                    x.printStackTrace()
                }
            }
        }
    }

    fun simpanToFirebase(name: String, email: String, password: String, spinner: String, phone: String) {
        val uidUser = fAuth.currentUser?.uid
        val uid = helperPref.getUID()
        val nameXXX = UUID.randomUUID().toString()
        val storageRef: StorageReference = storageReference
            .child("profile/$uid/$nameXXX.${GetFileExtension(filePathImage)}")
        storageRef.putFile(filePathImage).addOnSuccessListener {
            storageRef.downloadUrl.addOnSuccessListener {
                dbRef = FirebaseDatabase.getInstance().getReference("dataUser/$uidUser")
                dbRef.child("/id").setValue(uidUser)
                dbRef.child("/nama").setValue(name)
                dbRef.child("/email").setValue(email)
                dbRef.child("/password").setValue(password)
                dbRef.child("/phone").setValue(phone)
                dbRef.child("/gender").setValue(spinner)
                dbRef.child("/profile").setValue(it.toString())
            }
            Toast.makeText(
                this,
                "Success Upload",
                Toast.LENGTH_SHORT
            ).show()
            progressReg.visibility = View.GONE
        }.addOnFailureListener {
            Log.e("TAG_ERROR", it.message)
        }.addOnProgressListener { taskSnapshot ->
            value = (100.0 * taskSnapshot
                .bytesTransferred / taskSnapshot.totalByteCount)
            progressReg.visibility = View.VISIBLE
        }
        startActivity(Intent(this, LoginActivity::class.java))

    }

    fun GetFileExtension(uri: Uri): String? {
        val contentResolver = this.contentResolver
        val mimeTypeMap = MimeTypeMap.getSingleton()
        return mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(uri))
    }
}
