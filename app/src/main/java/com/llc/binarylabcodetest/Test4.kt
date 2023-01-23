package com.llc.binarylabcodetest

import android.util.Log

class Test4 {

    fun main(){
        val list = listOf(1, 2, 3, 4, 5)
        val sumValues = mutableListOf<Int>()
        list.forEachIndexed { index, i ->
            sumValues.add(index, list.sum() - i)
        }
        val result = "${sumValues.min()} ${sumValues.max()}"
        Log.i("Min and Max values:", result)
    }
}