package com.abid.confiados.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.abid.confiados.R
import kotlinx.android.synthetic.main.edit_profile.*

class EditProfile : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.edit_profile)
        setSupportActionBar(toolbarEdit)
        supportActionBar!!.title = "EDIT PROFILE"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

    }
}
