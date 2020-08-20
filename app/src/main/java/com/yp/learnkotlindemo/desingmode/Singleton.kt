package com.yp.learnkotlindemo.desingmode

import android.util.Log
import java.io.Serializable

/**
 * Time：2020/8/18
 * Description：单例模式
 */
// 饿汉式
object Singleton: Serializable{//实现Serializable序列化接口，通过私有、被实例化的readResolve方法控制反序列化

    // 防止单例对象在反序列化时重新生成对象
    private fun readResolve():Any{
        // 由于反序列化时会调用readResolve这个钩子方法，只需要把当前的Singleton对象返回而不是去创建一个新的对象
        return Singleton
    }

    fun doSomething(){
        Log.e("TAG", "doSomething: 饿汉式"  )
    }


}
// 懒汉式
class Singleton2 private constructor(): Serializable{

    // 防止单例对象在反序列化时重新生成对象
    private fun readResolve():Any{
        // 由于反序列化时会调用readResolve这个钩子方法，只需要把当前的Singleton对象返回而不是去创建一个新的对象
        return instance
    }

    fun doSomething(){
        Log.e("TAG", "doSomething: 懒汉式"  )
    }

    companion object{
        //通过@JvmStatic注解，使得在Java中调用instance直接是像调用静态函数一样，
        //类似KLazilyDCLSingleton.getInstance(),如果不加注解，在Java中必须这样调用: KLazilyDCLSingleton.Companion.getInstance().
        @JvmStatic
        //使用lazy属性代理，并指定LazyThreadSafetyMode为SYNCHRONIZED模式保证线程安全
        val instance: Singleton2 by lazy(LazyThreadSafetyMode.SYNCHRONIZED)  { Singleton2() }
    }



}