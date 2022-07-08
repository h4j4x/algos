package com.h4j4x.algos.kotlin.sort

class Counting : Sorter {
    override fun name() = "COUNTING"

    override fun sort(arr: IntArray) {
        val min = arr.minBy { it }
        val max = arr.maxBy { it }
        val countArr = IntArray(max - min + 1)
    }
}
