package com.yanpu.net

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.io.Serializable

/**
 * @Date: 2020/9/1 14:46
 * @Description:
 */
object RetrofitInstance : Serializable {

    // 防止单例对象在反序列化时重新生成对象
    private fun readResolve(): Any {
        // 由于反序列化时会调用readResolve这个钩子方法，只需要把当前的Singleton对象返回而不是去创建一个新的对象
        return RetrofitInstance
    }

    var retrofit: Retrofit?=null

    fun init(baseUrl: String, client: OkHttpClient) {

        retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .build()
    }

}