package com.abid.confiados.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.abid.confiados.R
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.detail_destination.*

class DetailDestination : AppCompatActivity() {

    lateinit var fAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_destination)
        setSupportActionBar(toolbar_detail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.title = "DETAIL"
        fAuth = FirebaseAuth.getInstance()
        val iduser = intent.getStringExtra("iduser")
        val name = intent.getStringExtra("nama_user")
        val imageProf = intent.getStringExtra("foto_profile")
        val noTelp = intent.getStringExtra("notelp")
        val gen = intent.getStringExtra("gender")
        val bukti = intent.getStringExtra("bukti")
        val destination = intent.getStringExtra("destination")
        val startDate = intent.getStringExtra("startDate")
        val endDate = intent.getStringExtra("endDate")
        nameTraveller_on_detail.text = name
        Glide.with(this).load(imageProf)
            .centerCrop()
            .error(R.drawable.ic_launcher_background)
            .into(photo_profile_on_detail)
        contact_on_detail.text = noTelp
        genderTraveller_on_detail.text = gen
        Glide.with(this).load(bukti)
            .centerCrop()
            .error(R.drawable.ic_launcher_background)
            .into(bukti_on_detail)
        destination_on_detail.text = destination
        start_date_on_detail.text = startDate
        end_date_on_detail.text = endDate
        photo_profile_on_detail.setOnClickListener {
            if (iduser == fAuth.uid) {
                startActivity(Intent(this, ProfileActivity::class.java))
            } else {
                val intent: Intent = Intent(this, ShowProfileOtherUser::class.java)
                intent.putExtra("iduser", iduser)
                intent.putExtra("name", name)
                startActivity(intent)
            }
        }
    }
}