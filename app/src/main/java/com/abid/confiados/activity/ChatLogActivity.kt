package com.abid.confiados.activity


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.abid.confiados.R
import com.abid.confiados.model.ChatMessage
import com.abid.confiados.model.UserModel
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.squareup.picasso.Picasso
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.activity_chat_log.*
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.chat_from_row.view.*
import kotlinx.android.synthetic.main.chat_to_row.view.*
import kotlinx.android.synthetic.main.custom_message.*
import java.sql.Timestamp

class ChatLogActivity : AppCompatActivity() {
    val adapter = GroupAdapter<ViewHolder>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_log)
        setSupportActionBar(toolbar2)

        val name = intent.getStringExtra("nama_user")
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = name



        rcViewChat.adapter = adapter
        listenForMessage()

        buttonSendMessages.setOnClickListener {

            Log.d("CHAT","Berhasil")
            performSendMessage()
        }
    }

    private fun listenForMessage() {
        val ref = FirebaseDatabase.getInstance().getReference("messages")
        ref.addChildEventListener(object : ChildEventListener{
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onChildMoved(p0: DataSnapshot, p1: String?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onChildChanged(p0: DataSnapshot, p1: String?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onChildAdded(p0: DataSnapshot, p1: String?) {
                val chatMessage = p0.getValue(ChatMessage::class.java)
                Log.d("TESCHAT",chatMessage?.text)
                if (chatMessage != null){
                    if (chatMessage.fromId != FirebaseAuth.getInstance().uid){
                        adapter.add(ChatFromItem(chatMessage.text))
                    }else{
                        adapter.add(ChatToItem(chatMessage.text))
                    }
                }
            }

            override fun onChildRemoved(p0: DataSnapshot) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })
    }


    fun performSendMessage() {
        val iduser = intent.getStringExtra("id_user")
        val text = editTextMessage.text.toString()
        val fromId = FirebaseAuth.getInstance().uid
        val toId = iduser
        if (fromId == null) return
        val reference = FirebaseDatabase.getInstance().getReference("messages").push()
        val chatMessage = ChatMessage(reference.key!! , text,fromId,toId,System.currentTimeMillis() / 1000)
        reference.setValue(chatMessage)
            .addOnSuccessListener {
                Log.d("Message","Saved our message chat : ${reference.key}")
                rcViewChat.scrollToPosition(adapter.itemCount -1 )
            }
        editTextMessage.setText("")
    }

    class ChatFromItem(val text:String): Item<ViewHolder>(){
        override fun getLayout(): Int {
           return R.layout.chat_from_row
        }

        override fun bind(viewHolder: ViewHolder, position: Int) {
            viewHolder.itemView.chatFrom.text = text
        }

    }
    class ChatToItem(val text:String): Item<ViewHolder>(){
        override fun getLayout(): Int {
            return R.layout.chat_to_row
        }

        override fun bind(viewHolder: ViewHolder, position: Int) {
            viewHolder.itemView.chatTo.text = text
        }

    }
}

