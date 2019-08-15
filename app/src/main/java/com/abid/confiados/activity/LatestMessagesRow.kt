package com.abid.confiados.activity

import android.util.Log
import com.abid.confiados.R
import com.abid.confiados.model.ChatMessage
import com.abid.confiados.model.UserModel
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.lates_messages_row.view.*

class LatestMessagesRow(val chatMessage: ChatMessage) : Item<ViewHolder>() {
    var chatPartnerUser: UserModel? = null

    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.itemView.message_textview_latest_message.text = chatMessage.text

        val chatPartnerId: String
        if (chatMessage.fromId == FirebaseAuth.getInstance().uid) {
            chatPartnerId = chatMessage.toId
            Log.d("FROMID",chatPartnerId)
        } else {
            chatPartnerId = chatMessage.fromId
            Log.d("FROMID",chatPartnerId)
        }

        val ref = FirebaseDatabase.getInstance().getReference("dataUser/$chatPartnerId")
        ref.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(p0: DataSnapshot) {
                chatPartnerUser = p0.getValue(UserModel::class.java)
                viewHolder.itemView.textUserLatesMessages.text = chatPartnerUser?.nama
                val targetImageView = viewHolder.itemView.imgProfileLatesMessage
                Glide.with(viewHolder.itemView).load(chatPartnerUser?.profile).centerCrop().into(targetImageView)
            }
            override fun onCancelled(p0: DatabaseError) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })
    }
    override fun getLayout(): Int {
        return R.layout.lates_messages_row
    }
}