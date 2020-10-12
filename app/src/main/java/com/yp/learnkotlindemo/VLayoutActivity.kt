package com.yp.learnkotlindemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.vlayout.DelegateAdapter
import com.alibaba.android.vlayout.VirtualLayoutManager
import com.alibaba.android.vlayout.layout.LinearLayoutHelper
import com.yp.learnkotlindemo.adapter.Test1VLayoutAdapter
import com.yp.learnkotlindemo.bean.UserBean
import kotlinx.android.synthetic.main.activity_v_layout.*

class VLayoutActivity : AppCompatActivity() {

    var adapterList = mutableListOf<DelegateAdapter.Adapter<*>>()

    var mutableListOf: MutableList<UserBean>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_v_layout)

        var layoutManager = VirtualLayoutManager(this)
        rv_list.layoutManager = layoutManager

        //设置回收复用池大小，（如果一屏内相同类型的 View 个数比较多，需要设置一个合适的大小，防止来回滚动时重新创建 View）
        var viewPool = RecyclerView.RecycledViewPool();
        rv_list.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(0, 20);

        //设置适配器
        var delegateAdapter = DelegateAdapter(layoutManager, true)

        rv_list.adapter = delegateAdapter
        var adapter = Test1VLayoutAdapter(this, R.layout.item_test_1_v_layout, LinearLayoutHelper(), 0, 1)



        adapterList.add(adapter)

        delegateAdapter.addAdapters(adapterList)

        mutableListOf = mutableListOf(
            UserBean("张三", 10, "芙蓉区"),
            UserBean("李四", 15, "岳麓区"), UserBean("王五", 23, "天心区"), UserBean("王五", 23, "天心区")
        )
        adapter.mList = mutableListOf
        adapter.count = mutableListOf?.size ?: 0

        adapter.notifyDataSetChanged()



    }
}