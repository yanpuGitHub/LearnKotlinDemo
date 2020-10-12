package com.yanpu.net.service

import retrofit2.Call
import retrofit2.http.*

/**
 * @Date: 2020/9/1 15:58
 * @Description:
 */
interface IService {

    @GET
    fun get(@Url url: String, @QueryMap map: HashMap<String, Any>): Call<String>

    @FormUrlEncoded
    @POST
    fun post(@Url url:String, @QueryMap map: HashMap<String, Any>): Call<String>
}