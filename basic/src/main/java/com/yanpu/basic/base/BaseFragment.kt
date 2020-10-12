package com.yanpu.basic.base

import android.app.Activity
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import java.lang.Exception

/**
 * @Date: 2020/9/1 9:49
 * @Description:
 */
open class BaseFragment<T : BaseActivity> : Fragment() {

    protected var activity: T? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onAttach(activity: Activity) {
        super.onAttach(activity)
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M)
            onAttachToContext(activity)
    }

    private fun onAttachToContext(context: Context) {
        activity = getActivity() as T?
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        try {
            inflateView()
            initData()
            initAttach()
        } catch (e: Exception) {

        }
    }

    fun inflateView() {

    }

    fun initData() {

    }

    fun initAttach() {

    }

    override fun onStart() {
        super.onStart()
        if (null == activity) {
            activity = getActivity() as T?
        }
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    protected fun isAvailable(): Boolean {

        return null != activity && isAdded
    }
}