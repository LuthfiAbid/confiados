package com.abid.confiados.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.util.Log
import com.abid.confiados.R
import com.abid.confiados.adapter.DestinationAdapter
import com.abid.confiados.fragment.ChatFragment
import com.abid.confiados.model.ChatMessage
import com.abid.confiados.model.UserModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.activity_lates_messages.*

class LatesMessagesActivity : AppCompatActivity() {
    companion object {
        var currentUser: UserModel? = null
        val adapter = GroupAdapter<ViewHolder>()
        val fAuth = FirebaseAuth.getInstance()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lates_messages)
        recyclerViewLatesMessages.adapter = adapter
        recyclerViewLatesMessages.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        adapter.setOnItemClickListener { item, view ->
            Log.d("TESINTENTCHAT", "123")
            val intent = Intent(this, ChatLogActivity::class.java)
            // we are missing the chat partner user
            val row = item as LatestMessagesRow
            intent.putExtra("id_user", row.chatPartnerUser)
            startActivity(intent)
        }
        listenForLatestMessages()
        fetchCurrentUser()
    }
    val latesMessageMap = HashMap<String, ChatMessage>()
    private fun refreshRecyclerViewMessages() {
        adapter.clear()
        latesMessageMap.values.forEach {
            adapter.add(LatestMessagesRow(it))
        }
    }
    private fun listenForLatestMessages() {
        val fromId = FirebaseAuth.getInstance().uid
        val ref = FirebaseDatabase.getInstance().getReference("/latest-messages/$fromId")
        ref.addChildEventListener(object : ChildEventListener {
            override fun onChildAdded(p0: DataSnapshot, p1: String?) {
                val chatMessage = p0.getValue(ChatMessage::class.java) ?: return
                adapter.add(LatestMessagesRow(chatMessage))
                latesMessageMap[p0.key!!] = chatMessage
                refreshRecyclerViewMessages()
                Log.d("TAGLATESMESSAGES", chatMessage.text)
            }
            override fun onChildChanged(p0: DataSnapshot, p1: String?) {
                val chatMessage = p0.getValue(ChatMessage::class.java) ?: return
                latesMessageMap[p0.key!!] = chatMessage
                refreshRecyclerViewMessages()
                Log.d("TAGLATESMESSAGES", chatMessage.text)
            }
            override fun onChildMoved(p0: DataSnapshot, p1: String?) {

            }
            override fun onChildRemoved(p0: DataSnapshot) {

            }
            override fun onCancelled(p0: DatabaseError) {

            }
        })
    }

    private fun fetchCurrentUser() {
        val uid = FirebaseAuth.getInstance().uid
        val ref = FirebaseDatabase.getInstance().getReference("/dataUser/$uid")
        ref.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(p0: DataSnapshot) {
                currentUser = p0.getValue(UserModel::class.java)
                Log.d("LatestMessages", "Current user ${currentUser?.nama}")
            }
            override fun onCancelled(p0: DatabaseError) {
            }
        })
    }
}

