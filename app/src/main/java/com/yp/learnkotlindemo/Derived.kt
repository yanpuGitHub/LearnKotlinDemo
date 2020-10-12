package com.yp.learnkotlindemo

import android.util.Log

/**
 * Time：2020/8/20
 * Description：
 */

class Derived(d:DerivedCallback):DerivedCallback by d {

    override fun printMessage() {
        Log.e("TAG", "print: 123")
    }

}