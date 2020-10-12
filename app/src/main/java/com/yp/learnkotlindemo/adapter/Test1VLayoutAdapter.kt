package com.yp.learnkotlindemo.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
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

class Test1VLayoutAdapter(
    context: Context,
    layoutId: Int,
    layoutHelper: LayoutHelper,
    count: Int,
    viewItemType: Int
) : BaseVLayoutAdapter(context, layoutId, layoutHelper, count, viewItemType) {


    var mList: MutableList<UserBean>? = null

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        var tvName = holder.getView<TextView>(R.id.tv_name)
        var tvAge = holder.getView<TextView>(R.id.tv_age)
        var tvAddress = holder.getView<TextView>(R.id.tv_address)
        var layoutItem = holder.getView<LinearLayout>(R.id.layout_item)
        mList?.also {
            with(it[position]) {
                    tvName.text = name
                    tvAge.text = age.toString()
                    tvAddress.text = address
                if (position%2==0){
                    layoutItem.setBackgroundColor(context.resources.getColor(R.color.colorPrimary))
                }
            }
        }
    }


}