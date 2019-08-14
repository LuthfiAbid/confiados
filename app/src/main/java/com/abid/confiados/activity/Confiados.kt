package com.abid.confiados.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.abid.confiados.R
import com.abid.confiados.adapter.ConfiadosAdapter
import com.abid.confiados.data.Pref
import com.abid.confiados.model.ConfiadosModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.confiados.*
import java.util.ArrayList

class Confiados : AppCompatActivity() {

    lateinit var dbRef: DatabaseReference
    lateinit var pref: Pref
    private var confiadosAdapter: ConfiadosAdapter? = null
    private lateinit var fAuth: FirebaseAuth
    private var recyclerView: RecyclerView? = null
    private var list: MutableList<ConfiadosModel> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.confiados)
        setSupportActionBar(toolbarConf)
        supportActionBar!!.title = "CONFIADOS"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        addConfiados.setOnClickListener {
            startActivity(Intent(this, AddConfiados::class.java))
            finish()
        }

        var linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView = findViewById(R.id.recyclerViewConfiados)
        recyclerView!!.layoutManager = linearLayoutManager
        recyclerView!!.setHasFixedSize(true)

        fAuth = FirebaseAuth.getInstance()

        dbRef = FirebaseDatabase.getInstance()
            .reference.child("dataConfiados")
        dbRef.orderByChild("iduser").equalTo(fAuth.uid).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(p0: DataSnapshot) {
                list = ArrayList()
                for (dataSnapshot in p0.children) {
                    val addDataAll = dataSnapshot.getValue(
                        ConfiadosModel::class.java
                    )
                    addDataAll!!.key = dataSnapshot.key
                    list.add(addDataAll)
                    confiadosAdapter = ConfiadosAdapter(this@Confiados, list)
                    recyclerView!!.adapter = confiadosAdapter
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