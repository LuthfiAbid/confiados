package com.abid.confiados.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.abid.confiados.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.activity_chat_log.*
import java.sql.Timestamp

class ChatLogActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_log)
        setSupportActionBar(toolbar2)
        val name = intent.getStringExtra("nama_user")
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = name

        val adapter = GroupAdapter<ViewHolder>()

        adapter.add(ChatFromItem())
        adapter.add(ChatToItem())
        adapter.add(ChatFromItem())
        adapter.add(ChatToItem())
        rcViewChat.adapter = adapter

        buttonSendMessages.setOnClickListener {
            performSendMessage()
        }
    }

    class ChatMessage(key: String?, pesan: String, fromId:String,toId:String,timestamp: Long) {

    }

    fun performSendMessage() {
        val iduser = intent.getStringExtra("id_user")
        val pesan = editTextMessage.text.toString()
        val fromId = FirebaseAuth.getInstance().uid
        val toId = iduser
        if (fromId == null) return
        val reference = FirebaseDatabase.getInstance().getReference("messages").push()
        val chatMessage = ChatMessage(reference.key!! , pesan,fromId,toId,System.currentTimeMillis() / 1000)
    }

    class ChatFromItem: Item<ViewHolder>(){
        override fun getLayout(): Int {
           return R.layout.chat_from_row
        }

        override fun bind(viewHolder: ViewHolder, position: Int) {

        }

    }
    class ChatToItem: Item<ViewHolder>(){
        override fun getLayout(): Int {
            return R.layout.chat_to_row
        }

        override fun bind(viewHolder: ViewHolder, position: Int) {
        }

    }
}

