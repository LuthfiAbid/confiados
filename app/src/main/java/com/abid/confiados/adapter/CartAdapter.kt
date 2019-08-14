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
import com.abid.confiados.model.ConfiadosModel
import com.abid.confiados.model.DestinationModel
import com.abid.confiados.model.UserModel
import com.bumptech.glide.Glide
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class CartAdapter : RecyclerView.Adapter<CartAdapter.ConfiadosViewHolder> {
    lateinit var mCtx: Context
    lateinit var itemConfiados: List<ConfiadosModel>

    constructor()
    constructor(mCtx: Context, list: List<ConfiadosModel>) {
        this.mCtx = mCtx
        this.itemConfiados = list
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ConfiadosViewHolder {
        val view: View = LayoutInflater.from(p0.context)
            .inflate(R.layout.item_list_confiados, p0, false)
        val confiadosViewHolder = ConfiadosViewHolder(view)
        return confiadosViewHolder
    }

    override fun getItemCount(): Int {
        return itemConfiados.size
    }

    override fun onBindViewHolder(p0: ConfiadosViewHolder, p1: Int) {
        val confiadosModel: ConfiadosModel = itemConfiados.get(p1)
        FirebaseDatabase.getInstance()
            .getReference("dataUser/")
            .child(confiadosModel.iduser!!)
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(data2: DataSnapshot) {
                    val userData =
                        data2.getValue(UserModel::class.java)
                    confiadosModel.user = userData
                    Glide.with(mCtx).load(confiadosModel.user!!.profile)
                        .centerCrop()
                        .error(R.drawable.ic_launcher_background)
                        .into(p0.imageProfile)
                    p0.tv_name.text = confiadosModel.user!!.nama
                    p0.tv_gender.text = confiadosModel.user!!.gender
                }

                override fun onCancelled(p0: DatabaseError) {
                    Log.e("cok", p0.message)
                }
            })
        p0.tv_confiados.text = confiadosModel.confiados
    }

    inner class ConfiadosViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var llConfiados: LinearLayout
        var imageProfile: ImageView
        var tv_name: TextView
        var tv_gender: TextView
        var tv_confiados: TextView

        init {
            llConfiados = itemView.findViewById(R.id.llConfiados)
            imageProfile = itemView.findViewById(R.id.profilePicTravellerConfiados)
            tv_name = itemView.findViewById(R.id.nameProfileTravellerConfiados)
            tv_gender = itemView.findViewById(R.id.genderProfileTravellerConfiados)
            tv_confiados = itemView.findViewById(R.id.confiadosItemList)
        }
    }

}