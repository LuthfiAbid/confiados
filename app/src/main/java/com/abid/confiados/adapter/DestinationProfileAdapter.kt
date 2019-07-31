package com.abid.confiados.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.abid.confiados.Preferences
import com.abid.confiados.R
import com.abid.confiados.model.DestinationModel
import com.bumptech.glide.Glide
import com.google.firebase.database.DatabaseReference

class DestinationProfileAdapter : RecyclerView.Adapter<DestinationProfileAdapter.DestinationViewHolder> {
    lateinit var mCtx: Context
    lateinit var itemDestination: List<DestinationModel>
    lateinit var pref: Preferences
    lateinit var dbRef: DatabaseReference

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
        Glide.with(mCtx).load(destinationModel.getImage())
            .centerCrop()
            .error(R.drawable.ic_launcher_background)
            .into(p0.imageProfile)
        p0.tv_name.text = destinationModel.getName()
        p0.tv_gender.text = destinationModel.getGender()
        p0.tv_destination.text = destinationModel.getDestination()
        p0.tv_startDate.text = destinationModel.getStartDate()
        p0.tv_endDate.text = destinationModel.getEndDate()
    }

    inner class DestinationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ll: LinearLayout
        var imageProfile: ImageView
        var tv_name: TextView
        var tv_gender: TextView
        var tv_destination: TextView
        var tv_startDate: TextView
        var tv_endDate: TextView

        init {
            ll = itemView.findViewById(R.id.ll)
            imageProfile = itemView.findViewById(R.id.profilePicTraveller)
            tv_name = itemView.findViewById(R.id.nameProfileTraveller)
            tv_gender = itemView.findViewById(R.id.genderProfileTraveller)
            tv_destination = itemView.findViewById(R.id.textProfileDestination)
            tv_startDate = itemView.findViewById(R.id.startTravelingDateProfile)
            tv_endDate = itemView.findViewById(R.id.homeTravelingDateProfile)
        }
    }

}