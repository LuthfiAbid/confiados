package com.abid.confiados.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.abid.confiados.Preferences
import com.abid.confiados.R
import com.abid.confiados.adapter.DestinationAdapter
import com.abid.confiados.model.DestinationModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class HomeFragment : Fragment() {

    private val dest = "DESTINATION"
    private lateinit var fAuth: FirebaseAuth
    private var bukuAdapter: DestinationAdapter? = null
    private var recyclerView: RecyclerView? = null
    private var list: MutableList<DestinationModel> = ArrayList<DestinationModel>()
    lateinit var dbRef: DatabaseReference
    lateinit var pref: Preferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    companion object {
        fun newInstance(): HomeFragment {
            val fragment = HomeFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        title.text = dest
        recyclerView = view.findViewById(R.id.recyclerViewDestination)
        recyclerView!!.layoutManager = LinearLayoutManager(context)
        recyclerView!!.setHasFixedSize(true)

        pref = Preferences(context!!)
        fAuth = FirebaseAuth.getInstance()

        dbRef = FirebaseDatabase.getInstance()
            .getReference("destination/${pref.getUID()}")
        dbRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(p0: DataSnapshot) {
                list = ArrayList()
                for (dataSnapshot in p0.children) {
                    val addDataAll = dataSnapshot.getValue(
                        DestinationModel::class.java
                    )
                    addDataAll!!.setKey(dataSnapshot.key!!)
                    list.add(addDataAll)
                    bukuAdapter = DestinationAdapter(context!!, list)
                    recyclerView!!.adapter = bukuAdapter
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
