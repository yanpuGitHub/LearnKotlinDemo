package com.yp.learnkotlindemo

interface SimpleCallback {

    fun onSuccess(code: Int)

    fun onError(errStr: String)

}