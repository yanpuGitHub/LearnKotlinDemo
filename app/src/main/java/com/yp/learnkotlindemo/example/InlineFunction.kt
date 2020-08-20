package com.yp.learnkotlindemo.example

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.util.TypedValue
import android.view.Gravity
import android.widget.TextView
import com.yp.learnkotlindemo.R
import com.yp.learnkotlindemo.bean.UserBean

/**
 *
 * 内联函数
 *
 * 函数名	    定义inline的结构	                                   函数体内使用的对象	   返回值	  是否是扩展函数	    适用的场景

 *  let      fun <T, R> T.let(block: (T) -> R): R = block(this) 	it指代当前对象	闭包形式返回	        是	    适用于处理不为null的操作场景

 *  with	fun <T, R> with(receiver: T, block: T.() -> R): R = receiver.block()	this指代当前对象或者省略	闭包形式返回	否	适用于调用同一个类的多个方法时，可以省去类名重复，直接调用类的方法即可，经常用于Android中RecyclerView中onBinderViewHolder中，数据model的属性映射到UI上

 *  run 	fun <T, R> T.run(block: T.() -> R): R = block()     this指代当前对象或者省略	闭包形式返回	是	适用于let,with函数任何场景。

 *  apply	fun T.apply(block: T.() -> Unit): T { block(); return this }	this指代当前对象或者省略	返回this	是
 *   1、适用于run函数的任何场景，一般用于初始化一个对象实例的时候，操作对象属性，并最终返回这个对象。
 *   2、动态inflate出一个XML的View的时候需要给View绑定数据也会用到.
 *   3、一般可用于多个扩展函数链式调用
 *   4、数据model多层级包裹判空处理的问题

 *  also	fun T.also(block: (T) -> Unit): T { block(this); return this }	it指代当前对象	返回this	是	适用于let函数的任何场景，一般可用于多个扩展函数链式调用
 */
// 用object 修饰的类为静态类，里面的方法和变量都为静态的。
object InlineFunction {
    private val TAG = InlineFunction::class.java.simpleName

    private var list = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)

    /**
     * let函数对一个非null对象做处理
     */
    @SuppressLint("SetTextI18n")
    fun inlineLet(context: Context, view: TextView) {
        view.let {
            it.text = "KOTLIN--->let"
            it.gravity = Gravity.CENTER
            it.setTextColor(context.resources.getColor(R.color.colorAccent))
            it.setTextSize(TypedValue.COMPLEX_UNIT_SP, 41F)
        }
    }

    /**
     * with函数，主要用于调用同一个类的多个方法时，例 adapter里设置数据
     */
    fun inlineWith(list: MutableList<UserBean>) {
        for (i in list.indices) {
            var name = with(list[i]) {
                Log.e(TAG, "inlineWith----> name=$name, age = $age, address=$address")
                name
            }
            Log.e(TAG, "inlineWith: $name")
        }
    }

    /**
     * run函数，let和with的结合体
     */
    fun inlineRun(list: MutableList<UserBean>) {
        for (i in list.indices) {
            var name = list[i].run {
                Log.e(TAG, "inlineWith----> name=$name, age = $age, address=$address")
                name
            }

            Log.e(TAG, "inlineWith: $name")
        }
    }

    /**
     * apply函数，跟run函数很像返回是对象本身
     */
    fun inlineApply(list: MutableList<UserBean>) {
        for (i in list.indices) {
            var bean: UserBean = list[i].apply {
                Log.e(TAG, "inlineWith----> name=$name, age = $age, address=$address")
                name = "马六"
            }

            Log.e(TAG, "inlineWith: " + bean.name)
        }
    }

    /**
     * also函数，跟let函数很像返回是对象本身
     */
    fun inlineAlso(list: MutableList<UserBean>) {
        for (i in list.indices) {
            var bean: UserBean = list[i].also {
                Log.e(TAG, "inlineWith----> name=$it.name, age = $it.age, address=$it.address")
                it.name = "赵七"
            }

            Log.e(TAG, "inlineWith: " + bean.name)
        }
    }
}