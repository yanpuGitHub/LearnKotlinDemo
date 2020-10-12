package com.yanpu.net.context

/**
 * @Date: 2020/9/1 19:37
 * @Description:
 */
open class BridgeContext : CoreContext() {

    companion object {

        const val KEY_LOGOUT = "logout" //标注退出原因

        var CLS_WELCOME: String? = null
        var CLS_LOGIN: String? = null
        var CLS_HOME: String? = null

        //三方通信开关
        var isReport = false

        val URI_MARKET = "market://details?id=%s"

        const val KEY_EB_ID = "id"
        const val KEY_VAR_1 = "var1"
        const val KEY_VAR_2 = "var2"
        const val KEY_VAR_3 = "var3"
        const val KEY_VAR_BRIDGE = "bridge"

        var DESIGN_WIDTH = 375
        var DESIGN_HEIGHT = 667

        //崩溃
        const val KEY_CRASH = "isCrash"
        var KEY_ENV = "env"
        var CRASH_INFO_MAX = 1024

        var LINE = "\n"
        var TAB = "\t"
    }
}