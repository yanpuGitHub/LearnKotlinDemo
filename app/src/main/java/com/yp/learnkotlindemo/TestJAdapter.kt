package com.yp.learnkotlindemo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class TestJAdapter(private val context: Context, private val mList: List<BaseBean>?) :
    RecyclerView.Adapter<TestJAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflate = LayoutInflater.from(context).inflate(R.layout.activity_main2, null)
        return ViewHolder(inflate)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.itemView.setOnClickListener {
            this.listener.onSuccess(0)
            this.listener.onError("失败")
        }
    }

    override fun getItemCount(): Int {
        return mList?.size ?: 0
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    fun setOnItemClickListener(onItemClickListener: (BaseBean, Int) -> Unit) {
        this.onItemClickListener = onItemClickListener
    }

    private lateinit var onItemClickListener: (BaseBean, Int) -> Unit

    private lateinit var listener: SimpleCallback

    fun setSimpleCallback(listener: SimpleCallbackImpl.() -> Unit) {
        var builder = SimpleCallbackImpl()
        builder.listener()
        this.listener = builder
    }
}