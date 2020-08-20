package com.yp.learnkotlindemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.FrameLayout
import android.widget.TextView
import com.google.android.material.tabs.TabLayout
import com.yp.learnkotlindemo.bean.UserBean
import com.yp.learnkotlindemo.desingmode.Singleton
import com.yp.learnkotlindemo.example.ControlFlow
import com.yp.learnkotlindemo.example.InlineFunction
import com.yp.learnkotlindemo.util.Logger
import com.yp.learnkotlindemo.util.logg
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), DetailCallback {

    private val TAG = MainActivity::class.java.simpleName
    private lateinit var layoutTab: TabLayout
    private lateinit var layoutFrame: FrameLayout
    private lateinit var stringArray: Array<String>

    private lateinit var adapter: TestJAdapter

    private var valueInt: Int = 97
    private var valueInt2: Int? = valueInt

    private var valueInt3: Int = 128
    private var valueInt4: Int? = valueInt3

    private var string: String? = null
    private lateinit var tvText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var length = string?.length ?: -17
        var mList = listOf<BaseBean>()
        adapter = TestJAdapter(this, mList)
        adapter.setOnItemClickListener { bean, position ->
            var code = bean.code
            var info = mList[position]
            var msg = info.msg
            Log.e(TAG, "code --->> $code")
            Log.e(TAG, "msg --->> $msg")
        }

        Logger.e(TAG, "哈哈")
        logg.e(TAG, "呵呵")
        adapter.setSimpleCallback {
            onSuccessFun { code, msg ->
            }

            onErrorFun { code, msg ->
            }
        }

        Log.e(TAG, "valueInt --->> " + (valueInt == valueInt2) + ",,,," + (valueInt === valueInt2))

        Log.e(TAG, "valueInt --->> byte: " + (valueInt.toByte()))
        Log.e(TAG, "valueInt --->> short: " + (valueInt.toShort()))
        Log.e(TAG, "valueInt --->> int: " + (valueInt.toInt()))
        Log.e(TAG, "valueInt --->> long: " + (valueInt.toLong()))
        Log.e(TAG, "valueInt --->> float: " + (valueInt.toFloat()))
        Log.e(TAG, "valueInt --->> double: " + (valueInt.toDouble()))
        Log.e(TAG, "valueInt --->> char: " + (valueInt.toChar()))
        Log.e(TAG, "valueInt --->> string: " + (valueInt.toString()))

        Log.e(
            TAG,
            "valueInt --->> " + (valueInt3 == valueInt4) + ",,,," + (valueInt3 === valueInt4) + ",,,,," + (valueInt3.equals(
                valueInt4
            ))
        )


        layoutTab = findViewById(R.id.layout_table)
        layoutFrame = findViewById(R.id.layout_contain)

//        tvText = findViewById(R.id.tv_text)

        var list = mutableListOf<UserBean>(UserBean("张三",10, "芙蓉区"),
            UserBean("李四",15, "岳麓区"),UserBean("王五",23, "天心区"))

        also {
            with(InlineFunction){
                inlineLet(it, tv_text)
                inlineWith(list)
                inlineRun(list)
                inlineApply(list)
                inlineAlso(list)
            }
        }
        Singleton.doSomething()

        stringArray = resources.getStringArray(R.array.tab)

        for (text in stringArray) {
            layoutTab.addTab(layoutTab.newTab())
        }

        for ((index, value) in stringArray.withIndex()) {
            var newTab = layoutTab.getTabAt(index)
            newTab?.text = value
        }

        // for循环的使用
        ControlFlow.forMethod()
        ControlFlow.ifMethod(3)
        WhileIterator.remove()




        var arrayList = arrayOf(1, 2, "a", false, 3, "r", true)
        var iterator = arrayList.iterator()
        while (iterator.hasNext()) {
            Log.e(TAG, "iii --->> ${iterator.next()}")
        }

        var ints = listOf(10, 1, 2, 3, 4, 5, 6, 7, 8, 9)
        for (i in ints) {
            Log.e(TAG, "i --->> $i")
        }
        forEach_label(ints)

        main()
    }

    fun forEach_label(ints: List<Int>) {

        /**
         * 循环遍历
         */
        ints.forEach {
            Log.e(TAG, "iii ---forEach >> $it")
        }

        run outer@{
            ints.forEach {
                if (it == 0) return@forEach //相当于在forEach函数中continue,实际上是从匿名函数返回
                if (it == 2) return@outer //相当于在forEach函数中使用break,实际上是跳转到outer之外
                Log.e(TAG, "iii --->> $it")
            }
        }
    }

    override fun detail() {
        TODO("Not yet implemented")
    }

    /**
     *  :: 方法的引用
     */
    fun main() {
        foo(3, this::methodFunction)
    }


    fun methodFunction(a: String) {
        Log.e(TAG, "methodFunction --->>$a")
    }

    fun foo(s: Int, body: (String) -> Unit) {
        body(((s + 12).toString()))
    }


}