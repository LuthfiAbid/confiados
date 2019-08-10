package com.abid.confiados.activity

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.widget.FrameLayout
import com.abid.confiados.data.Pref
import com.abid.confiados.R
import com.abid.confiados.fragment.CartFragment
import com.abid.confiados.fragment.HomeFragment
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var fAuth: FirebaseAuth
    private var recyclerView: RecyclerView? = null
    lateinit var dbRef: DatabaseReference
    lateinit var pref: Pref
    private var content: FrameLayout? = null
    val manager = supportFragmentManager

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                HomeFrag()
                return@OnNavigationItemSelectedListener true
            }
//            R.id.navigation_chat -> {
//                val fragment = UploadFragment()
//                addFragment(fragment)
//            }
            R.id.navigation_cart -> {
               CartFrag()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }
//
//    private fun addFragment(fragment: Fragment) {
//        supportFragmentManager
//            .beginTransaction()
//            .setCustomAnimations(
//                R.anim.design_bottom_sheet_slide_in,
//                R.anim.design_bottom_sheet_slide_out
//            )
//            .replace(R.id.content, fragment, fragment.javaClass.simpleName)
//            .commit()
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pref = Pref(this)
        HomeFrag()
        fAuth = FirebaseAuth.getInstance()
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        FirebaseDatabase.getInstance().getReference("dataUser/${fAuth.uid}")
            .child("profile").addListenerForSingleValueEvent(object : ValueEventListener {

                override fun onDataChange(p0: DataSnapshot) {
                    Glide.with(this@MainActivity).load(p0.value.toString())
                        .centerCrop()
                        .error(R.drawable.ic_launcher_background)
                        .into(profileMain)
                }

                override fun onCancelled(p0: DatabaseError) {

                }
            })

        upload_destination.setOnClickListener {
            startActivity(Intent(this, UploadActivity::class.java))
        }

        profileMain.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }
    }
    fun HomeFrag() {
        val transaction = manager.beginTransaction()
        val fragment = HomeFragment()
        transaction.replace(R.id.content, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    fun CartFrag() {
        val transaction = manager.beginTransaction()
        val fragment = CartFragment()
        transaction.replace(R.id.content, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
