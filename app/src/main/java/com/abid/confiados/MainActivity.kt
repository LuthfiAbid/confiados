package com.abid.confiados

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.widget.FrameLayout
import com.abid.confiados.fragment.CartFragment
import com.abid.confiados.fragment.HomeFragment
import com.abid.confiados.fragment.UploadFragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var fAuth: FirebaseAuth
    private var recyclerView: RecyclerView? = null
    lateinit var dbRef: DatabaseReference
    lateinit var pref: Preferences
    private var content: FrameLayout? = null
    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                val fragment = HomeFragment.newInstance()
                addFragment(fragment)
            }
            R.id.navigation_upload -> {
                val fragment = UploadFragment()
                addFragment(fragment)
            }
            R.id.navigation_cart -> {
                val fragment = CartFragment()
                addFragment(fragment)
            }
        }
        false
    }

    private fun addFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(R.anim.design_bottom_sheet_slide_in, R.anim.design_bottom_sheet_slide_out)
            .replace(R.id.content, fragment, fragment.javaClass.simpleName)
            .commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pref = Preferences(this)
        fAuth = FirebaseAuth.getInstance()
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        val fragment = HomeFragment.newInstance()
        addFragment(fragment)

        circleImageView.setOnClickListener {
            startActivity(Intent(this,ProfileActivity::class.java))
        }
    }
}
