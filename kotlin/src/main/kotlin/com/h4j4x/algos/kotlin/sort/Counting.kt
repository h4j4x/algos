package com.h4j4x.algos.kotlin.sort

class Counting : Sorter {
    override fun name() = "COUNTING"

    override fun sort(arr: IntArray) {
        val max = arr.maxBy { it }
        val countArr = IntArray(max + 1)
        for (value in arr) {
            countArr[value]++
        }
        for (index in 1..countArr.lastIndex) {
            countArr[index] += countArr[index - 1]
        }
        val unsortedArr = arr.copyOf()
        for (value in unsortedArr) {
            arr[countArr[value] - 1] = value
            countArr[value]--
        }
    }
}
