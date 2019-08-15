package com.abid.confiados.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.abid.confiados.R
import com.abid.confiados.model.DestinationModel
import com.abid.confiados.model.UserModel
import com.squareup.picasso.Picasso

class DestAdapter(val dests: ArrayList<DestinationModel>, val context: Context) : BaseAdapter() {


    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val dest = dests.get(position)
        val view = LayoutInflater.from(context).
                inflate(R.layout.item_destination, parent, false)

        val txtUser : TextView = view.findViewById(R.id.txtDest)
        txtUser.text = dest.destination
        return view
    }

    override fun getItem(position: Int): Any {
        return dests.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return dests.size
    }
}