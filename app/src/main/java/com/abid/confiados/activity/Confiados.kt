package com.abid.confiados.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.abid.confiados.R
import kotlinx.android.synthetic.main.confiados.*

class Confiados : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.confiados)
        setSupportActionBar(toolbarConf)
        supportActionBar!!.title = "CONFIADOS"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }
}
