package com.yp.learnkotlindemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.Gravity
import android.widget.FrameLayout
import android.widget.TextView
import com.google.android.material.tabs.TabLayout
import com.yp.learnkotlindemo.util.LoggerUtil
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

        LoggerUtil.e(TAG, "哈哈")
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

        tv_text?.let {
            Log.e(TAG, "i --->> $45664")
            it.setText("KOTLIN")
            it.gravity = Gravity.CENTER
            it.setTextColor(resources.getColor(R.color.colorAccent))
            it.setTextSize( TypedValue.COMPLEX_UNIT_SP,41F)
        }

        stringArray = resources.getStringArray(R.array.tab)

        for (text in stringArray) {
            layoutTab.addTab(layoutTab.newTab())
        }

        for (i in 0..5) {
            Log.e(TAG, "i --->> $i")
        }

        for (i in 0 until 5) {
            Log.e(TAG, "i --->> $i")
        }

        for (i in 6 downTo 5 step 3) {
            Log.e(TAG, "i --->> $i")
        }

        for ((index, value) in stringArray.withIndex()) {
            val tabAt = layoutTab.getTabAt(index)
            tabAt?.text = value
        }
        var arrayList = arrayOf(1, 2, "a", false, 3, "r", true)
        for (i in arrayList) {
            Log.e(TAG, "i --->> $i")
        }

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
        Log.e(TAG, "iii --->> iii")
        var i = 3
        ints.forEach {
//            //forEach中无法使用continue和break;
////        if (it == 0) continue //编译错误
////        if (it == 2) /*break //编译错误 */
//            print(it)
            Log.e(TAG, "iii ---forEach >> $it")
        }
       run outer@{
            ints.forEach {
                if (it > 3){
                    LoggerUtil.e(TAG, it.toString())
                    return@outer
                }
            }
        }
        run outer@{
            ints.forEach {
                if (it == 0) return@forEach //相当于在forEach函数中continue,实际上是从匿名函数返回
                if (it == 2) return@outer //相当于在forEach函数中使用break,实际上是跳转到outer之外
                Log.e(TAG, "iii --->> $it")
            }
        }

//        }
        if (i == 3) {
//            Log.e(TAG, "iii --->> $it")
            //每个函数的名字代表一个函数地址，所以函数自动成为标签
            return@forEach_label //等同于return
        }
    }

    override fun detail() {
        TODO("Not yet implemented")
    }

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