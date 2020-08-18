package com.yp.learnkotlindemo.util

import android.util.Log

object Logger {

    private val TAG = "TEST"

    fun e(str: String) {

    }

    fun e(tag: String, str: String) {
        Log.e(tag, str)
    }
}