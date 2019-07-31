package com.abid.confiados

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {
    lateinit var pref: Preferences
    private lateinit var fAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        fAuth = FirebaseAuth.getInstance()
        pref = Preferences(this)
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
