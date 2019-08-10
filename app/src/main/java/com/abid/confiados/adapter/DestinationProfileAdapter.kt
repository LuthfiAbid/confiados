package com.abid.confiados.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.abid.confiados.R
import com.abid.confiados.model.DestinationModel
import com.abid.confiados.model.UserModel
import com.bumptech.glide.Glide
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class DestinationProfileAdapter : RecyclerView.Adapter<DestinationProfileAdapter.DestinationViewHolder> {
    lateinit var mCtx: Context
    lateinit var itemDestination: List<DestinationModel>

    constructor()
    constructor(mCtx: Context, list: List<DestinationModel>) {
        this.mCtx = mCtx
        this.itemDestination = list
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): DestinationViewHolder {
        val view: View = LayoutInflater.from(p0.context)
            .inflate(R.layout.item_list_destination_on_profile, p0, false)
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
    }

    inner class DestinationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var llProfile: LinearLayout
        var imageProfile: ImageView
        var tv_name: TextView
        var tv_gender: TextView
        var tv_destination: TextView
        var tv_startDate: TextView
        var tv_endDate: TextView

        init {
            llProfile = itemView.findViewById(R.id.llProfile)
            imageProfile = itemView.findViewById(R.id.profilePicTraveller)
            tv_name = itemView.findViewById(R.id.nameProfileTraveller)
            tv_gender = itemView.findViewById(R.id.genderProfileTraveller)
            tv_destination = itemView.findViewById(R.id.textProfileDestination)
            tv_startDate = itemView.findViewById(R.id.startTravelingDateProfile)
            tv_endDate = itemView.findViewById(R.id.homeTravelingDateProfile)
        }
    }

}