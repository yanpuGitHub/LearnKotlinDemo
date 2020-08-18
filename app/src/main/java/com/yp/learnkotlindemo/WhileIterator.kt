package com.yp.learnkotlindemo

import android.util.Log
import java.util.*

object WhileIterator {
    fun remove() {
        val list: MutableList<Int> = ArrayList()
        list.add(0)
        list.add(1)
        list.add(2)
        list.add(3)
        list.add(4)
        list.add(5)
        list.add(6)
        list.add(7)
        list.add(8)
        val iterator = list.iterator()
        while (iterator.hasNext()) {
            val next = iterator.next()
            if (next % 2 == 0) {
                iterator.remove()
            }
        }
        for (i in list.indices) {
            Log.e("TAG", "remove----->> " + list[i])
        }
    }
}