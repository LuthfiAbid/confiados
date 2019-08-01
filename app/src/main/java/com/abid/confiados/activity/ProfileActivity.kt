package com.abid.confiados.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.abid.confiados.data.Preferences
import com.abid.confiados.R
import com.abid.confiados.adapter.DestinationProfileAdapter
import com.abid.confiados.model.DestinationModel
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_profile.*
import java.util.ArrayList

class ProfileActivity : AppCompatActivity() {
    lateinit var dbRef: DatabaseReference
    lateinit var pref: Preferences
    private var destinationProfileAdapter: DestinationProfileAdapter? = null
    private lateinit var fAuth: FirebaseAuth
    private var recyclerView: RecyclerView? = null
    private var list: MutableList<DestinationModel> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        fAuth = FirebaseAuth.getInstance()
        pref = Preferences(this)
        setSupportActionBar(toolbar)
        supportActionBar!!.title = "PROFILE"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        FirebaseDatabase.getInstance().getReference("dataUser/${fAuth.uid}")
            .child("profile").addListenerForSingleValueEvent(object : ValueEventListener {

                override fun onDataChange(p0: DataSnapshot) {
                    Glide.with(this@ProfileActivity).load(p0.value.toString())
                        .centerCrop()
                        .error(R.drawable.ic_launcher_background)
                        .into(profilePic)
                }

                override fun onCancelled(p0: DatabaseError) {

                }
            })

        FirebaseDatabase.getInstance().getReference("dataUser/${fAuth.uid}")
            .child("nama").addListenerForSingleValueEvent(object : ValueEventListener {

                override fun onDataChange(p0: DataSnapshot) {
                    profileName.text = p0.value.toString()
                }

                override fun onCancelled(p0: DatabaseError) {

                }
            })
        FirebaseDatabase.getInstance().getReference("dataUser/${fAuth.uid}")
            .child("phone").addListenerForSingleValueEvent(object : ValueEventListener {

                override fun onDataChange(p0: DataSnapshot) {
                    noTelepon.text = p0.value.toString()
                }

                override fun onCancelled(p0: DatabaseError) {

                }
            })
        FirebaseDatabase.getInstance().getReference("dataUser/${fAuth.uid}")
            .child("gender").addListenerForSingleValueEvent(object : ValueEventListener {

                override fun onDataChange(p0: DataSnapshot) {
                    profileGender.text = p0.value.toString()
                }

                override fun onCancelled(p0: DatabaseError) {

                }
            })

        pref = Preferences(this)
        var linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView = findViewById(R.id.recyclerViewProfileDestination)
        recyclerView!!.layoutManager = linearLayoutManager
        recyclerView!!.setHasFixedSize(true)

        fAuth = FirebaseAuth.getInstance()
        val uid = pref.getUID()

        dbRef = FirebaseDatabase.getInstance()
            .reference.child("destination")
        dbRef.orderByChild("iduser").equalTo(fAuth.uid).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(p0: DataSnapshot) {
                list = ArrayList()
                for (dataSnapshot in p0.children) {
                    val addDataAll = dataSnapshot.getValue(
                        DestinationModel::class.java
                    )
                    addDataAll!!.setKey(dataSnapshot.key!!)
                    list.add(addDataAll)
                    destinationProfileAdapter = DestinationProfileAdapter(this@ProfileActivity, list)
                    recyclerView!!.adapter = destinationProfileAdapter
                }
            }

            override fun onCancelled(p0: DatabaseError) {
                Log.e(
                    "TAG_ERROR", p0.message
                )
            }
        })

        btn_confiados.setOnClickListener {
            startActivity(
                Intent(
                    this, Confiados::class.java
                )
            )
        }

        bt_editProf.setOnClickListener {
            startActivity(
                Intent(
                    this, EditProfile::class.java
                )
            )
        }

        btn_logout.setOnClickListener {
            pref.setStatus(false)
            fAuth.signOut()
            startActivity(
                Intent(
                    this, LoginActivity::class.java
                )
            )
        }
    }
}
