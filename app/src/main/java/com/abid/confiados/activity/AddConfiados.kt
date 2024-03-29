package com.abid.confiados.activity

import android.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import com.abid.confiados.R
import com.abid.confiados.adapter.ConfiadosAdapter
import com.abid.confiados.adapter.CountryAdapter
import com.abid.confiados.adapter.DestinationProfileAdapter
import com.abid.confiados.adapter.UserAdapter
import com.abid.confiados.data.Pref
import com.abid.confiados.model.CountryModel
import com.abid.confiados.model.DestinationModel
import com.abid.confiados.model.UserModel
import com.abid.confiados.utils.ApiClient
import com.abid.confiados.utils.ApiInterface
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_add_confiados.*
import kotlinx.android.synthetic.main.activity_upload.*
import kotlinx.android.synthetic.main.item_list_confiados.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

class AddConfiados : AppCompatActivity() {

    lateinit var pref: Pref
    var counter = 0
    var id = ""
    lateinit var dbRef: DatabaseReference
    lateinit var fAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_confiados)
        pref = Pref(this)
        fAuth = FirebaseAuth.getInstance()
        setSupportActionBar(toolbarAddConf)
        supportActionBar!!.title = "ADD CONFIADOS"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        add_Conf.setOnClickListener {
            showUser()
        }
        prof_conf.setOnClickListener {
            showUser()
        }

        btn_add_confiados.setOnClickListener {
            val userTitip = user_on_add_confiados.text.toString()
            val confiados = et_confiados.text.toString()

            if (confiados.isNotEmpty() || userTitip.isNotEmpty()) {
                addToFirebase(confiados)
                pref.saveCounterId(counter + 1)
            } else {
                Toast.makeText(
                    this,
                    "Fill Data",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun showUser() {
        var dialog: AlertDialog
        val builder = AlertDialog.Builder(this)
        val view = LayoutInflater.from(this).inflate(R.layout.popup_user, null)

        builder.setView(view)
        val searchUser: EditText = view.findViewById(R.id.searchUser)
        val listUser: ListView = view.findViewById(R.id.listUser)
        getUser(listUser)
        searchUser.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s!!.isNotEmpty()) {
                    getUser(listUser, s.toString())
                } else {
                    getUser(listUser)
                }
            }

        })
        dialog = builder.create()
        dialog.show()
        listUser.setOnItemClickListener { parent, view, position, id ->
            add_Conf.visibility = View.GONE
            prof_conf.visibility = View.VISIBLE
            val user = parent.adapter.getItem(position) as UserModel
            this.id = user.id
            user_on_add_confiados.text = user.nama
            dialog.dismiss()
        }
    }

    private fun addToFirebase(confiados: String) {
        val idcounter = pref.getCounterId()
        val uid = fAuth.currentUser?.uid
        dbRef = FirebaseDatabase.getInstance().getReference("dataConfiados/$idcounter")
        dbRef.child("confiados").setValue(confiados)
        dbRef.child("iduser").setValue(uid)
        dbRef.child("idusertitip").setValue(id)
    }

    fun getUser(listUser: ListView) {
        dbRef = FirebaseDatabase.getInstance().getReference("dataUser")
        dbRef.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {
                var list = ArrayList<UserModel>()
                for (dataSnapshot in p0.children) {
                    val addDataAll = dataSnapshot.getValue(
                        UserModel::class.java
                    )
                    if (addDataAll!!.id != fAuth.uid) {
                        addDataAll!!.key = dataSnapshot.key!!
                        list.add(addDataAll)
                    }
                    listUser.adapter = UserAdapter(list, this@AddConfiados)
                }
            }

        })
    }

    fun getUser(listUser: ListView, name: String) {
        dbRef = FirebaseDatabase.getInstance().getReference("dataUser")

        dbRef.orderByChild("nama")
            .startAt(name)
            .endAt(name+"\uf8ff").addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {
                var list = ArrayList<UserModel>()
                for (dataSnapshot in p0.children) {
                    val addDataAll = dataSnapshot.getValue(
                        UserModel::class.java
                    )
                    if (addDataAll!!.id != fAuth.uid) {
                        addDataAll!!.key = dataSnapshot.key!!
                        list.add(addDataAll)
                    }
                    listUser.adapter = UserAdapter(list, this@AddConfiados)
                }
            }

        })
    }
}
