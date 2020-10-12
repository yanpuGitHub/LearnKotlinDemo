package com.yanpu.net.manager

import com.yanpu.net.RetrofitInstance
import com.yanpu.net.bean.ExtDataBean

/**
 * @Date: 2020/9/1 14:38
 * @Description:
 */
open class BaseManager {

    fun <T> getService(cls: Class<T>): T? {
        return RetrofitInstance.retrofit?.create(cls)
    }

    interface Callback<B> {

        fun onSuccess(bean: B, extBean: ExtDataBean)

        fun onError(code: Int, str: String, extBean: ExtDataBean?)
    }
}