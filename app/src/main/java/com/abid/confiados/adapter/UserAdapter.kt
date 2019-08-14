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
import com.abid.confiados.model.UserModel
import com.squareup.picasso.Picasso

class UserAdapter(val users: ArrayList<UserModel>, val context: Context) : BaseAdapter() {


    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val user = users.get(position)
        val view = LayoutInflater.from(context).
                inflate(R.layout.item_user, parent, false)

        val imgUser : ImageView = view.findViewById(R.id.imgUser)
        val txtUser : TextView = view.findViewById(R.id.txtUser)

        Picasso.with(context)
            .load(user.profile)
            .centerCrop()
            .resize(50, 50)
            .error(R.drawable.unknown_avatar)
            .into(imgUser)

        txtUser.text = user.nama
        return view
    }

    override fun getItem(position: Int): Any {
        return users.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return users.size
    }
}