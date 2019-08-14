package com.abid.confiados.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.abid.confiados.R
import com.abid.confiados.adapter.DestinationProfileAdapter
import com.abid.confiados.data.Pref
import com.abid.confiados.model.DestinationModel
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.show_profile_other_user.*
import java.util.ArrayList

class ShowProfileOtherUser : AppCompatActivity() {

    lateinit var dbRef: DatabaseReference
    lateinit var pref: Pref
    private var destinationProfileAdapter: DestinationProfileAdapter? = null
    private lateinit var fAuth: FirebaseAuth
    private var recyclerView: RecyclerView? = null
    private var list: MutableList<DestinationModel> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.show_profile_other_user)
        setSupportActionBar(toolbarO)
        val iduser = intent.getStringExtra("iduser")
        supportActionBar?.title = "PROFILE"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        FirebaseDatabase.getInstance().getReference("dataUser/$iduser")
            .child("profile").addListenerForSingleValueEvent(object : ValueEventListener {

                override fun onDataChange(p0: DataSnapshot) {
                    Glide.with(this@ShowProfileOtherUser).load(p0.value.toString())
                        .centerCrop()
                        .error(R.drawable.ic_launcher_background)
                        .into(profilePicO)
                }

                override fun onCancelled(p0: DatabaseError) {

                }
            })

        FirebaseDatabase.getInstance().getReference("dataUser/$iduser")
            .child("nama").addListenerForSingleValueEvent(object : ValueEventListener {

                override fun onDataChange(p0: DataSnapshot) {
                    profileNameO.text = p0.value.toString()
                }

                override fun onCancelled(p0: DatabaseError) {

                }
            }
            )
        FirebaseDatabase.getInstance().getReference("dataUser/$iduser")
            .child("phone").addListenerForSingleValueEvent(object : ValueEventListener {

                override fun onDataChange(p0: DataSnapshot) {
                    noTeleponO.text = p0.value.toString()
                }

                override fun onCancelled(p0: DatabaseError) {

                }
            }
            )
        FirebaseDatabase.getInstance().getReference("dataUser/$iduser")
            .child("gender").addListenerForSingleValueEvent(object : ValueEventListener {

                override fun onDataChange(p0: DataSnapshot) {
                    profileGenderO.text = p0.value.toString()
                }

                override fun onCancelled(p0: DatabaseError) {

                }
            }
            )
        var linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView = findViewById(R.id.recyclerViewOtherProfileDestination)
        recyclerView!!.layoutManager = linearLayoutManager
        recyclerView!!.setHasFixedSize(true)

        fAuth = FirebaseAuth.getInstance()

        dbRef = FirebaseDatabase.getInstance()
            .reference.child("destination")
        dbRef.orderByChild("iduser").equalTo(iduser).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(p0: DataSnapshot) {
                list = ArrayList()
                for (dataSnapshot in p0.children) {
                    val addDataAll = dataSnapshot.getValue(
                        DestinationModel::class.java
                    )
                    addDataAll!!.key = dataSnapshot.key
                    list.add(addDataAll)
                    destinationProfileAdapter = DestinationProfileAdapter(this@ShowProfileOtherUser, list)
                    recyclerView!!.adapter = destinationProfileAdapter
                }
            }

            override fun onCancelled(p0: DatabaseError) {
                Log.e(
                    "TAG_ERROR", p0.message
                )
            }
        })
    }
}
