package com.yp.learnkotlindemo

import android.util.Log

/**
 * Time：2020/8/20
 * Description：
 */

class DerivedImpl(var a: Int) : DerivedCallback {
    override fun print() {
        Log.e("TAG", "print: $a")
    }

    override fun printMessage() {
        Log.e("TAG", "print: abc")
    }
}