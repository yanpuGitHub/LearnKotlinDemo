package com.yp.learnkotlindemo.adapter

import android.util.SparseArray
import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * Date：2020/8/24
 * Description：
 */
class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val viewSparseArray: SparseArray<View> = SparseArray()

    fun <T : View> getView(resId: Int): T {

        var view = viewSparseArray[resId]
        if (null == view) {
            view = itemView.findViewById(resId)
            viewSparseArray.put(resId, view)
        }
        return view as T
    }

    fun getItemView(): View {
        return itemView
    }

}