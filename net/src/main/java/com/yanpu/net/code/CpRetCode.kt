package com.yanpu.net.code

/**
 * @Date: 2020/9/1 20:07
 * @Description:
 */
object CpRetCode:BridgeRetCode() {

    const val OPEN_SUSS = 0 //API Suss

    const val OPEN_ERR = 1

    const val UNAUTHORIZED = -1 //未鉴权


    //需要重新登录
    const val LOGON_TIMEOUT = -10000
    const val LOGON_OTHER = -10001
    const val LOGON_RE = -10002

    //无权限-业务
    const val ERR_PERMISSION_BUSINESS = 10403



}