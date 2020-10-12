package com.yp.learnkotlindemo

open class BaseDataBean {

    var code: Int = 0
        get() {
            return field
        }
        set(value) {
            field = 1 + value
        }
    var msg: String? = ""
        get() {
            return field
        }
        set(value) {
            field = "1$value"
        }
}