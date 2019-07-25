package com.abid.confiados

import android.content.Context
import android.content.SharedPreferences

class Preferences {
    val USER_ID = "uidx"
    val COUNTER_ID = "counter"
    val statusLogin = "STATUS"
    val statusUserSlur = "STATUS_USER"


    var mContext: Context
    var sharedSet: SharedPreferences

    constructor(ctx: Context) {
        mContext = ctx
        sharedSet = mContext.getSharedPreferences("APLIKASITESDB", Context.MODE_PRIVATE)
    }

    fun saveUID(uid: String) {
        val edit = sharedSet.edit()
        edit.putString(USER_ID, uid)
        edit.apply()
    }

    fun getUID(): String? {
        return sharedSet.getString(USER_ID, " ")
    }

    fun setStatusUser(statusUser: Boolean) {
        val edit = sharedSet.edit()
        edit.putBoolean(statusUserSlur, statusUser)
        edit.apply()
    }

    fun saveCounterId(counter: Int) {
        val edit = sharedSet.edit()
        edit.putInt(COUNTER_ID, counter)
        edit.apply()
    }

    fun getCounterId(): Int {
        return sharedSet.getInt(COUNTER_ID, 1)
    }

    fun setEmail(email: String) {
        val editor: SharedPreferences.Editor = sharedSet.edit()
        editor.putString("EMAIL", email)
        editor.apply()
    }

    fun setStatusInput(status: Boolean) {
        val editor: SharedPreferences.Editor = sharedSet.edit()
        editor.putBoolean("STATUS", status)
        editor.apply()
    }

    fun setStatus(status: Boolean) {
        val edit = sharedSet.edit()
        edit.putBoolean(statusLogin, status)
        edit.apply()
    }

    fun cekStatus(): Boolean? {
        return sharedSet.getBoolean(statusLogin, false)
    }
}
