package com.abid.confiados.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CountryModel (
    @SerializedName("name") var name: String?,
    @SerializedName("flag") var flag: String
) : Serializable