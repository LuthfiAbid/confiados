package com.abid.confiados.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.abid.confiados.R
import com.abid.confiados.model.UserModel

class LatesMessagesActivity : AppCompatActivity() {
    companion object {
        var currentUser: UserModel? = null
        val TAG = "LatestMessages"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lates_messages)
    }
}
