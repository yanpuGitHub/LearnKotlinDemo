package com.yp.learnkotlindemo

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.alibaba.android.vlayout.DelegateAdapter
import com.alibaba.android.vlayout.LayoutHelper
import com.yp.learnkotlindemo.adapter.BaseViewHolder

/**
 * Date：2020/8/24
 * Description：
 */
open class TestJavaApader(
    private val context: Context,
    private val layoutId: Int,
    private val layoutHelper: LayoutHelper,
    private val count: Int,
    private val viewItemType: Int
) : DelegateAdapter.Adapter<BaseViewHolder>() {



    override fun onCreateLayoutHelper(): LayoutHelper {
        return layoutHelper
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {

           return BaseViewHolder(LayoutInflater.from(context).inflate(layoutId, parent, false))

    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {}
    override fun getItemViewType(position: Int): Int {
        return viewItemType
    }

    override fun getItemCount(): Int {
        return count
    }

}