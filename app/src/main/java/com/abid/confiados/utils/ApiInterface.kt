package com.abid.confiados.utils

import com.abid.confiados.model.CountryModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {

    @GET("all")
    fun getCountry() : Call<ArrayList<CountryModel>>

    @GET("name/{name}")
    fun getCountry(@Path("name")name: String) : Call<ArrayList<CountryModel>>
}