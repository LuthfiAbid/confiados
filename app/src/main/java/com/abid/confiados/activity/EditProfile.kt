package com.abid.confiados.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.abid.confiados.R
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.edit_profile.*

class EditProfile : AppCompatActivity() {
    lateinit var dbRef: DatabaseReference
    private lateinit var fAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.edit_profile)
        setSupportActionBar(toolbarEdit)
        fAuth = FirebaseAuth.getInstance()
        supportActionBar!!.title = "EDIT PROFILE"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        FirebaseDatabase.getInstance().getReference("dataUser/${fAuth.uid}")
            .child("profile").addListenerForSingleValueEvent(object : ValueEventListener {

                override fun onDataChange(p0: DataSnapshot) {
                    Glide.with(this@EditProfile).load(p0.value.toString())
                        .centerCrop()
                        .error(R.drawable.ic_launcher_background)
                        .into(img_placeholder_EditProfile)
                }

                override fun onCancelled(p0: DatabaseError) {

                }
            })

        FirebaseDatabase.getInstance().getReference("dataUser/${fAuth.uid}")
            .child("nama").addListenerForSingleValueEvent(object : ValueEventListener {

                override fun onDataChange(p0: DataSnapshot) {
                    et_editnama.setText(p0.value.toString())
                }

                override fun onCancelled(p0: DatabaseError) {

                }
            })
        FirebaseDatabase.getInstance().getReference("dataUser/${fAuth.uid}")
            .child("phone").addListenerForSingleValueEvent(object : ValueEventListener {

                override fun onDataChange(p0: DataSnapshot) {
                    et_editnohp.setText(p0.value.toString())
                }

                override fun onCancelled(p0: DatabaseError) {

                }
            })
    }
}
