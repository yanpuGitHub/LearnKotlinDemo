package com.yanpu.net.manager.callback

import com.yanpu.basic.bean.BaseBean
import com.yanpu.net.code.NetRetCode
import com.yanpu.net.manager.BaseManager
import retrofit2.Call
import retrofit2.Callback
import java.lang.Exception
import java.net.UnknownHostException

/**
 * @Date: 2020/9/1 16:07
 * @Description:
 */
open abstract class BasicCallback<T : Any, S : BaseBean>(var cb: BaseManager.Callback<S>) : Callback<T> {


    override fun onFailure(call: Call<T>, t: Throwable) {
        try {
            when (t) {
                t as UnknownHostException ->
                    cb.onError(NetRetCode.FAIL_NET_UNKNOWN_HOST, "", null)
            }


//            if (t instanceof UnknownHostException) {
//                cb.onError(NetRetCode.FAIL_NET_UNKNOWN_HOST, StringUtils.sub(Logger.DONT_SHOW, BaseApplication.getContext().getString(R.string.net_err_unknowhost)), null);
//            } else if (t instanceof SocketTimeoutException) {
//                cb.onError(NetRetCode.FAIL_NET_TIMEOUT_SOCKET, StringUtils.sub(Logger.DONT_SHOW, BaseApplication.getContext().getString(R.string.net_err_timeout)), null);
//            } else if (t instanceof ConnectException) {
//                cb.onError(NetRetCode.FAIL_NET_CONNECTION, StringUtils.sub(Logger.DONT_SHOW, BaseApplication.getContext().getString(R.string.net_err_connect)), null);
//            } else if (t instanceof RuntimeException) {
//                cb.onError(NetRetCode.FAIL_NET_RUNTIME, StringUtils.sub(Logger.DONT_SHOW, BaseApplication.getContext().getString(R.string.net_err_runtime)), null);
//            } else {
//                cb.onError(NetRetCode.FAIL_NET, StringUtils.sub(Logger.DONT_SHOW, BaseApplication.getContext().getString(R.string.net_err_null), t.getMessage()), null);
//            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


    abstract fun onSuccess(response: T, bean: S)

}