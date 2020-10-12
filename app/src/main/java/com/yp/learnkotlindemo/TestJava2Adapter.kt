package com.yp.learnkotlindemo

import android.content.Context
import com.alibaba.android.vlayout.LayoutHelper
import com.yp.learnkotlindemo.adapter.BaseVLayoutAdapter
import com.yp.learnkotlindemo.adapter.BaseViewHolder

/**
 * Date：2020/8/24
 * Description：
 */
class TestJava2Adapter(context: Context, layoutId: Int, layoutHelper: LayoutHelper, count: Int, viewItemType: Int) : BaseVLayoutAdapter(context, layoutId, layoutHelper, count, viewItemType) {



    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
    }
}