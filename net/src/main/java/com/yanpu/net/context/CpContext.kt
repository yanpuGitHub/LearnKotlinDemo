package com.yanpu.net.context

import android.content.Intent

/**
 * @Date: 2020/9/1 19:37
 * @Description:
 */
object CpContext: BridgeContext() {


    var isInitThrid = false

//    val TRANS_HEAD_HTTPS_FIX: String = StringUtils.sub(TRANS_HEAD_HTTPS, URL_AVOW, URL_SPEC, URL_SPEC)
//    val TRANS_HEAD_HTTP_FIX: String = StringUtils.sub(TRANS_HEAD_HTTP, URL_AVOW, URL_SPEC, URL_SPEC)

    /**
     * scheme协议头
     */
//    const val TRANS_HEAD_JYDATA = "jydata://"

    /**
     * 平台
     */
    const val PLATFROM = "android"

    /**
     * 应用包名 如：com.piaoshen.ticket
     */
    var PACKAGE_NAME: String? = null

    /**
     * 版本号 如：1.6.0
     */
    var VERSION_NAME: String? = null

    /**
     * versionCode 如：24
     */
    var VERSION_CODE = 0


    //传授格式关键字
    const val KEY_CODE = "errorCode"
    const val KEY_MESSAGE = "errorMsg"
    const val KEY_DATA = "data"

    /**
     * 用户唯一标识符
     *
     *
     * 格式： UDID_FORMAT
     * 存储： sp内 KEY_UDID
     * 示例： a-8b913775-e3d9-4844-9e50-12fd00df80cd
     */
    var UDID: String? = null

    const val KEY_UDID = "udid"
    const val UDID_FORMAT = "a-%s"

    /**
     * 应用安装时间戳
     */
    var TIME_INSTALL: Long = 0

    var DOMAIN = "https://api.jydata.com/"
    var DOMAIN_H5 = "https://e.jydata.com/"

    /**
     * 启动模式
     */
    var FLAGS_LOGON = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_SINGLE_TOP

    /**
     * 默认状态栏
     */
    var IS_BAR_DARK = false
    var IS_BAR_SHOW = true


    const val KEY_USER_ID = "usrId"

    const val KEY_TIMEOUT_CONNECT = "connectTimeout"
    const val KEY_TIMEOUT_READ = "readTimeout"
    const val KEY_TIMEOUT_WRITE = "writeTimeout"

    /**
     * 服务器时间补全
     */
    var TIME_SYNC_DIFF: Long = 0

    /**
     * 无权限 - 业务
     * 这个地方改走Jumper，不要直连
     */
    var CLS_ERR_PERMISSION_BUSINESS: String? = null
    var CLS_ERR_PERMISSION_BUSINESS_STOP: String? = null

}