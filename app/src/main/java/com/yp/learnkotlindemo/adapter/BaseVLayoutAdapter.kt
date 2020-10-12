package com.yp.learnkotlindemo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.vlayout.DelegateAdapter
import com.alibaba.android.vlayout.LayoutHelper
import com.yp.learnkotlindemo.R
import com.yp.learnkotlindemo.bean.UserBean
import kotlinx.android.synthetic.main.item_test_v_layout_list.view.*

/**
 * Date：2020/8/24
 * Description：
 */

open class BaseVLayoutAdapter : DelegateAdapter.Adapter<BaseViewHolder> {

    var context: Context
    var layoutId: Int
    var layoutHelper: LayoutHelper
    var count: Int
    var viewType: Int

    constructor(
        context: Context,
        layoutId: Int,
        layoutHelper: LayoutHelper,
        count: Int,
        viewType: Int
    ) {
        this.context = context
        this.layoutId = layoutId
        this.layoutHelper = layoutHelper
        this.count = count
        this.viewType = viewType
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        var inflate = LayoutInflater.from(context).inflate(layoutId, parent, false)
        return BaseViewHolder(inflate)
    }

    override fun getItemViewType(position: Int): Int {
        return viewType
    }

    override fun getItemCount(): Int {
        return count
    }

    override fun onCreateLayoutHelper(): LayoutHelper {
        return layoutHelper
    }


    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {

    }

}