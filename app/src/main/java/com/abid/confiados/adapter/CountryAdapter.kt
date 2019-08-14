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
import com.abid.confiados.model.CountryModel
import com.squareup.picasso.Picasso

class CountryAdapter(val countries: ArrayList<CountryModel>, val context: Context) : BaseAdapter() {


    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val country = countries.get(position)
        val view = LayoutInflater.from(context).
                inflate(R.layout.item_country, parent, false)

        val imgCountry : ImageView = view.findViewById(R.id.imgCountry)
        val txtCountry : TextView = view.findViewById(R.id.txtCountry)

        Picasso.with(context)
            .load(country.flag)
            .error(R.drawable.unknown_avatar)
            .into(imgCountry)

        txtCountry.text = country.name
        return view
    }

    override fun getItem(position: Int): Any {
        return countries.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return countries.size
    }
}