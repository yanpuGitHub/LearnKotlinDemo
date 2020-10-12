package com.yanpu.net.interceptor

import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

/**
 * @Date: 2020/9/1 15:10
 * @Description:
 */
class TokenClient {

    public fun getTokenClient(): OkHttpClient {
        return customBuilder(getBuilder()).build()
    }


    public fun customBuilder(builder: OkHttpClient.Builder): OkHttpClient.Builder {
        return builder
    }

    private fun getBuilder(): OkHttpClient.Builder {
        var builder = OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
//            .addInterceptor()
        return builder
    }
}