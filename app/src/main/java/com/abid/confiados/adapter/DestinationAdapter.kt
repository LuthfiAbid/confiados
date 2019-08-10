package com.abid.confiados.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.abid.confiados.data.Pref
import com.abid.confiados.R
import com.abid.confiados.activity.ChatLogActivity
import com.abid.confiados.activity.DetailDestination
import com.abid.confiados.fragment.HomeFragment
import com.abid.confiados.model.DestinationModel
import com.abid.confiados.model.UserModel
import com.bumptech.glide.Glide
import com.google.firebase.database.*

class DestinationAdapter : RecyclerView.Adapter<DestinationAdapter.DestinationViewHolder> {
    lateinit var mCtx: Context
    lateinit var itemDestination: List<DestinationModel>
    lateinit var pref: Pref
    lateinit var dbRef: DatabaseReference

    constructor()
    constructor(mCtx: Context, list: List<DestinationModel>) {
        this.mCtx = mCtx
        this.itemDestination = list
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): DestinationViewHolder {
        val view: View = LayoutInflater.from(p0.context)
            .inflate(R.layout.item_list_destination, p0, false)
        val bukuViewHolder = DestinationViewHolder(view)
        return bukuViewHolder
    }

    override fun getItemCount(): Int {
        return itemDestination.size
    }

    override fun onBindViewHolder(p0: DestinationViewHolder, p1: Int) {
        val destinationModel: DestinationModel = itemDestination.get(p1)

        FirebaseDatabase.getInstance()
            .getReference("dataUser/")
            .child(destinationModel.iduser!!)
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(data2: DataSnapshot) {
                    val userData =
                        data2.getValue(UserModel::class.java)
                    destinationModel.user = userData
                    Glide.with(mCtx).load(destinationModel.user!!.profile)
                        .centerCrop()
                        .error(R.drawable.ic_launcher_background)
                        .into(p0.imageProfile)
                    p0.tv_name.text = destinationModel.user!!.nama
                    p0.tv_gender.text = destinationModel.user!!.gender
                }

                override fun onCancelled(p0: DatabaseError) {
                    Log.e("cok", p0.message)
                }
            })
        p0.tv_destination.text = destinationModel.destination
        p0.tv_startDate.text = destinationModel.startDate
        p0.tv_endDate.text = destinationModel.endDate
        p0.chat.setOnClickListener {
            Toast.makeText(mCtx, "Tes", Toast.LENGTH_SHORT).show()
            val intent : Intent = Intent(mCtx, ChatLogActivity::class.java)
            intent.putExtra("nama_user", destinationModel.user!!.nama)
            intent.putExtra("foto_profil", destinationModel.user!!.profile)
            intent.putExtra("id_user", destinationModel.iduser)
            mCtx.startActivity(intent)
        }
        p0.ll.setOnClickListener {
            Toast.makeText(mCtx, "Detail", Toast.LENGTH_SHORT).show()
            val intent : Intent = Intent(mCtx, DetailDestination::class.java)
            intent.putExtra("nama_user", destinationModel.user!!.nama)
            intent.putExtra("foto_profil", destinationModel.user!!.profile)
            intent.putExtra("gender", destinationModel.user!!.gender)
            intent.putExtra("notelp", destinationModel.user!!.phone)
            intent.putExtra("id_user", destinationModel.iduser)
            intent.putExtra("destination", destinationModel.destination)
            intent.putExtra("startDate", destinationModel.startDate)
            intent.putExtra("endDate", destinationModel.endDate)
            intent.putExtra("bukti", destinationModel.bukti)
            mCtx.startActivity(intent)
        }
    }

    inner class DestinationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ll: LinearLayout
        var imageProfile: ImageView
        var chat: ImageView
        var tv_name: TextView
        var tv_gender: TextView
        var tv_destination: TextView
        var tv_startDate: TextView
        var tv_endDate: TextView

        init {
            ll = itemView.findViewById(R.id.ll)
            imageProfile = itemView.findViewById(R.id.profileTraveller)
            chat = itemView.findViewById(R.id.chatPersonMessage)
            tv_name = itemView.findViewById(R.id.nameTraveller)
            tv_gender = itemView.findViewById(R.id.genderTraveller)
            tv_destination = itemView.findViewById(R.id.textDestination)
            tv_startDate = itemView.findViewById(R.id.startTravelingDate)
            tv_endDate = itemView.findViewById(R.id.homeTravelingDate)
        }
    }
}