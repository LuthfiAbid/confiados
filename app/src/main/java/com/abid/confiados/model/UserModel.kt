package com.abid.confiados.model

import android.os.*
import kotlinx.android.parcel.*
import java.io.Serializable

//@Parcelize
class UserModel(
    var key: String,
    var id: String,
    var nama: String,
    var gender: String,
    var password: String,
    var phone: String,
    var email: String,
    var profile: String
):Serializable
    {
    constructor() : this("", "", "", "", "", "", "", "")
}