package com.llc.binarylabcodetest

import android.util.Log

class Test3{

    fun main() {

        val text = "hello"

        var outputString: StringBuilder = StringBuilder()
        repeat(text.length){
            val char = text.random()
            outputString.append(char)
        }

        val charsMap = mutableMapOf<Char, Int>()

        outputString.forEach{
            charsMap[it] = charsMap.getOrDefault(it, 0) + 1
        }

        Log.i("DuplicatedCharCount",charsMap.toString())
        Log.i("StringCompression",outputString.toString())
    }
}