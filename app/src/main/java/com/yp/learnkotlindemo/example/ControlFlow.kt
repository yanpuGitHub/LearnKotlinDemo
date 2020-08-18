package com.yp.learnkotlindemo.example

import android.util.Log

/**
 * 控制流
 */
object ControlFlow {

    private val TAG = ControlFlow::class.java.simpleName

    var arrayList = arrayListOf(1, 2, 3, 4, 3, 7, 8)

    /**
     * if 分支可以是代码块，最后一句是返回值
     */
    fun ifMethod(a: Int, b: Int = 5) {
        var c: Int
        var max = if (a > b) {
            c = a + 2
            c++
        } else {
            c = b + 1
            ++c
        }
        Log.e(TAG, "max if--->> $max")
    }

    /**
     * for循环用法
     */
    fun forMethod() {

        /**
         * [10, 0]
         */
        for (i in 10 downTo 0) {
            Log.e(TAG, "i downTo--->> $i")
        }

        /**
         * [0, 5]
         */
        for (i in 0..5) {
            Log.e(TAG, "i --->> $i")
        }

        /**
         * [0, 5)
         */
        for (i in 0 until 5) {
            Log.e(TAG, "i --->> $i")
        }

        /**
         * [6, 2] 递减，步长是3
         */
        for (i in 6 downTo 2 step 3) {
            Log.e(TAG, "i --->> $i")
        }

        /**
         * withIndex 遍历 获取值和索引
         */
        for ((index, value) in arrayList.withIndex()) {
            Log.e(TAG, "withIndex --->> $index ---> $value")
        }

        /**
         * 遍历取值
         */
        for (i in arrayList) {
            Log.e(TAG, "i --->> $i")
        }
    }

    /**
     * while 用法
     */
    fun whileMethod(){

        arrayList.add(1)
        var iterator = arrayList.iterator()
        while (iterator.hasNext()){
            var next = iterator.next()
            if (next == 1 ){
                iterator.remove()
            }
        }

    }

}