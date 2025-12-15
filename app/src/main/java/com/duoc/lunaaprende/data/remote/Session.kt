package com.duoc.lunaaprende.data.remote

import android.content.Context

class Session(context: Context) {

    private val prefs = context.getSharedPreferences("session", Context.MODE_PRIVATE)

    fun setLoggedIn(value: Boolean) {
        prefs.edit().putBoolean("isLogged", value).apply()
    }

    fun isLoggedIn(): Boolean {
        return prefs.getBoolean("isLogged", false)
    }

    fun logout() {
        setLoggedIn(false)
    }
}
