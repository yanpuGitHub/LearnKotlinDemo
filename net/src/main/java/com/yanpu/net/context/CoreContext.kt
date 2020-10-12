package com.yanpu.net.context

import com.yanpu.net.comment.Global

/**
 * @Date: 2020/9/1 19:43
 * @Description:
 */
open class CoreContext : Global() {

    companion object {

        const val DC_SERVICE_DATAMANAGER_SP = "sp_dc_us"

        const val URL_SPEC = "/"
        const val URL_AVOW = ":"
        const val OPER_PLUS = "+"
        const val SPLIT_COMMA = ","
        const val ZERO = 0
    }
}