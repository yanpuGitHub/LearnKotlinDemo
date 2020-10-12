package com.yanpu.net.code

/**
 * @Date: 2020/9/1 20:08
 * @Description:
 */
open class BaseRetCode {

    companion object{
        /**
         * 默认值/未实现
         */
        const val DEFAULT = -1

        /**
         * 成功/通过
         */
        const val SUSS = 2000

        /**
         * 拒绝
         */
        const val REJECT = 3001

        /**
         * 拒绝,行为码不匹配
         */
        const val REJECT_OPCODE = 3002

        /**
         * 失败
         */
        const val FAIL = 3100

        /**
         * 参数错误
         */
        const val FAIL_PARAMS = 3101

        /**
         * 本地持久化失败
         */
        const val FAIL_STORAGE_LOCAL = 3300


        /**
         * 内部错误
         */
        const val ERR = 5000

        /**
         * 不存在
         */
        const val ERR_NOTFOUND = 5001

        /**
         * 缺少操作码
         */
        const val ERR_NOTFOUND_OPCODE = 5002

        /**
         * 远端主机无法连通
         */
        const val ERROR_DE_CONNECTED_HOST_NOT = 5010

        /**
         * 网络不通
         */
        const val ERROR_DE_CONNECTED_LOCAL_NOT = 5011

        /**
         * 主机找不到
         */
        const val ERROR_DE_HOST_UNRESOLVED = 5012

        /**
         * 信道已关闭
         */
        const val ERROR_DE_CHANEL_CLOSED = 5013

        /**
         * 初始化异常,IO错误
         */
        const val ERROR_DE_INIT = 5014


        /**
         * 关闭时IO异常
         */
        const val ERROR_DE_CLOSE = 5015

        /**
         * 连接超时
         */
        const val ERROR_DE_CONNECTED_TIMEOUT = 5016

        /**
         * 要传的内容为空
         */
        const val ERROR_DE_CONTEXT_EMPTY = 5017

        /**
         * 协议,解析时长度不足
         */
        const val ERROR_DE_PROTOCOL_LENGTH_LESS = 5020

        /**
         * 协议，流长度不匹配
         */
        const val ERROR_DE_PROTOCOL_LENGTH_SUM = 5021

        /**
         * 协议，无效的起止符
         */
        const val ERROR_DE_PROTOCOL_FRONTIER = 5022

        /**
         * 协议编码,未预期类型,处理解析时
         */
        const val ERROR_BE_PROTOCOL_TYPE_UNEXCEPTED = 5023

        /**
         * 协议编码,未预期的数据等级,数据准备时
         */
        const val ERROR_BE_PROTOCOL_LEVEL_UNEXCEPTED = 5024

        /**
         * 协议解码,未预期类型,处理解析时
         */
        const val ERROR_DE_PROTOCOL_TYPE_UNEXCEPTED = 5025

        /**
         * 远程调用provider出现异常
         */
        const val ERROR_REMOTE_PROVIDER = 5030
    }
}