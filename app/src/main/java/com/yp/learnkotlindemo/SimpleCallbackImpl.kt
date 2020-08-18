package com.yp.learnkotlindemo

class SimpleCallbackImpl : SimpleCallback {

    private lateinit var successVal: (Int, String) -> Unit

    fun onSuccessFun(listener: (code: Int, meg: String) -> Unit) {
        this.successVal = listener
    }

    override fun onSuccess(code: Int) {
        successVal.invoke(code, "成功")
    }

    private lateinit var errorVal: (Int, String) -> Unit

    fun onErrorFun(listener: (code: Int, msg: String) -> Unit) {
        this.errorVal = listener;
    }

    override fun onError(errStr: String) {
        errorVal.invoke(1, errStr)
    }
}