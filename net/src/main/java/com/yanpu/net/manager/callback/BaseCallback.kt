package com.yanpu.net.manager.callback

import com.google.gson.Gson
import com.google.gson.JsonParser
import com.yanpu.basic.bean.BaseDataBean
import com.yanpu.net.bean.ExtDataBean
import com.yanpu.net.code.CpRetCode.ERR_PERMISSION_BUSINESS
import com.yanpu.net.code.CpRetCode.LOGON_OTHER
import com.yanpu.net.code.CpRetCode.LOGON_RE
import com.yanpu.net.code.CpRetCode.LOGON_TIMEOUT
import com.yanpu.net.code.CpRetCode.OPEN_ERR
import com.yanpu.net.code.CpRetCode.OPEN_SUSS
import com.yanpu.net.code.CpRetCode.UNAUTHORIZED
import com.yanpu.net.code.NetRetCode
import com.yanpu.net.comment.Global.Companion.EMPTY
import com.yanpu.net.context.CpContext.KEY_CODE
import com.yanpu.net.context.CpContext.KEY_DATA
import com.yanpu.net.context.CpContext.KEY_MESSAGE
import com.yanpu.net.manager.BaseManager
import retrofit2.Call
import retrofit2.Response
import java.lang.Exception
import java.lang.reflect.ParameterizedType

/**
 * @Date: 2020/9/1 16:28
 * @Description:
 */
class BaseCallback<T : String, S : BaseDataBean>(cb: BaseManager.Callback<S>) : BasicCallback<T, S>(cb) {

    override fun onSuccess(response: T, bean: S) {

    }

    override fun onResponse(call: Call<T>, response: Response<T>) {
        try {
            if (response.isSuccessful) {
                convert(response)
            } else {
                when (response.code()) {
                    NetRetCode.HTTP_401 -> {

                    }
                    else ->{
//                        cb.onError(NetRetCode.ERROR_SERVER, StringUtils.sub(Logger.DONT_SHOW, BaseApplication.getContext().getString(R.string.net_err_null), String.valueOf(response.code())), null);
                        cb.onError(NetRetCode.ERROR_SERVER,"", null)
                    }
                }
            }

        } catch (e: Exception) {
            e.printStackTrace()
            cb.onError(NetRetCode.FAIL_NET_RESPONSE, e.message ?: "", null)
        }
    }

    private fun convert(response: Response<T>) {
        var je = JsonParser.parseString(response.body())
        if (je.isJsonObject) {
            var jo = je.asJsonObject

            var code = jo.get(KEY_CODE).asInt
            var msg =
                if (null == jo.get(KEY_MESSAGE) || jo.get(KEY_MESSAGE).isJsonNull) EMPTY else jo.get(
                    KEY_MESSAGE
                ).asString

            var extBean = ExtDataBean(code, msg, jo.get(KEY_DATA).toString())

            when (code) {
                OPEN_SUSS -> {
                    var type =
                        (cb.javaClass.genericInterfaces[0] as ParameterizedType).actualTypeArguments[0]
                    var bean = Gson().fromJson<S>(jo.get(KEY_DATA), type)
                    response.body()?.let { onSuccess(it, bean) }
                    cb.onSuccess(bean, extBean)

                }
                OPEN_ERR -> {
                    cb.onError(NetRetCode.FAIL_NET_RESPONSE_CHECK, "", extBean)
                }

                UNAUTHORIZED,
                LOGON_TIMEOUT,
                LOGON_OTHER,
                LOGON_RE -> {
                    loginTimeout()
                }

                ERR_PERMISSION_BUSINESS -> {

                }

                else -> {
                    cb.onError(NetRetCode.FAIL_NET_RESPONSE_CHECK, msg, extBean)
                }
            }
        }
    }


    // 登陆超时
    private fun loginTimeout() {

    }


}