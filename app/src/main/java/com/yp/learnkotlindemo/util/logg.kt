package com.yp.learnkotlindemo.util

import android.util.Log

object logg {
    val TAG = logg::class.java.simpleName
    fun e(string: String) {
        e(TAG, string)
    }

    fun e(tag: String?, string: String) {
        Log.e(tag, "e: $string")
    }

    fun d(tag: String?, string: String) {
        Log.d(tag, "e: $string")
    }
}