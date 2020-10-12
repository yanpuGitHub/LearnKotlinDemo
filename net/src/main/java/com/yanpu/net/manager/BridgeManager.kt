package com.yanpu.net.manager

import com.yanpu.basic.bean.BaseDataBean
import com.yanpu.net.manager.callback.BaseCallback
import com.yanpu.net.service.IService
import retrofit2.Call

/**
 * @Date: 2020/9/1 15:53
 * @Description:
 */
class BridgeManager : BaseManager() {


    protected fun<B : BaseDataBean> get(obj: Any, url :String, map: HashMap<String, Any>, cb: Callback<B>){
        var call = getService(IService::class.java)?.get(url, map)
        call?.enqueue(BaseCallback<String, B>(cb))
    }

}