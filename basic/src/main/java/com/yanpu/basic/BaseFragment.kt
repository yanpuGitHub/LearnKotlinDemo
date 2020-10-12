package com.yanpu.basic

import android.app.Activity
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.yanpu.basic.base.BaseActivity

/**
 * @author : yanpu
 * @date : 2020-06-20
 * @description:
 */
class BaseFragment<T : BaseActivity?> : Fragment() {



    protected var activity: T? = null


    override fun onAttach(context: Context) {
        super.onAttach(context)
        onAttachToContext(context)
    }

    override fun onAttach(activity: Activity) {
        super.onAttach(activity)
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            onAttachToContext(activity)
        }
    }

    protected fun onAttachToContext(context: Context?) {
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
            e.printStackTrace()
        }
    }

    protected fun inflateView() {}
    protected fun initData() {}
    protected fun initAttach() {}
    override fun onStart() {
        super.onStart()
        if (null == activity) activity = getActivity() as T?
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

    override fun onDetach() {
        super.onDetach()
    }

    protected val isAvailable: Boolean
        protected get() = null != activity && isAdded
}