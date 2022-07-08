package com.h4j4x.algos.kotlin.sort

class Counting : Sorter {
    override fun name() = "COUNTING"

    override fun sort(arr: IntArray) {
        val max = arr.maxBy { it }
        val countArr = IntArray(max + 1)
        for (value in arr) {
            countArr[value] += 1
        }
        for (index in 1 until countArr.size) {
            countArr[index] += countArr[index - 1]
        }
        val copyArr = arr.copyOf()
        for (index in copyArr.lastIndex downTo 0) {
            arr[countArr[copyArr[index]] - 1] = copyArr[index]
            countArr[copyArr[index]] -= 1
        }
    }
}
