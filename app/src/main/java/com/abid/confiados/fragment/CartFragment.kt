package com.abid.confiados.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.abid.confiados.R
import com.abid.confiados.adapter.CartAdapter
import com.abid.confiados.adapter.ConfiadosAdapter
import com.abid.confiados.adapter.DestinationAdapter
import com.abid.confiados.data.Pref
import com.abid.confiados.model.ConfiadosModel
import com.abid.confiados.model.DestinationModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import java.util.ArrayList

class CartFragment : Fragment() {

    private lateinit var fAuth: FirebaseAuth
    private var cartAdapter: CartAdapter? = null
    private var recyclerView: RecyclerView? = null
    private var list: MutableList<ConfiadosModel> = ArrayList()
    lateinit var dbRef: DatabaseReference
    lateinit var pref: Pref

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cart, container, false)
    }

    companion object {
        fun newInstance(): CartFragment {
            val fragment = CartFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pref = Pref(context!!)
        var linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recyclerView = view.findViewById(R.id.recyclerViewCart)
        recyclerView!!.layoutManager = linearLayoutManager
        recyclerView!!.setHasFixedSize(true)
        fAuth = FirebaseAuth.getInstance()
        dbRef = FirebaseDatabase.getInstance()
            .getReference("dataConfiados")
        dbRef.orderByChild("idusertitip").equalTo(fAuth.uid).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(data: DataSnapshot) {
                list = ArrayList()
                for (dataSnapshot in data.children) {
                    val addDataAll =
                        dataSnapshot.getValue(ConfiadosModel::class.java)
                    addDataAll!!.key = dataSnapshot.key
                    list.add(addDataAll)
                    cartAdapter = CartAdapter(context!!, list)
                    recyclerView!!.adapter = cartAdapter
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
