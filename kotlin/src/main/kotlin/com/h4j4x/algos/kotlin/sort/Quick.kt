package com.h4j4x.algos.kotlin.sort

class Quick : Sorter {
    override fun name() = "QUICK"

    override fun sort(arr: IntArray) {
        sort(arr, 0, arr.size)
    }

    private fun sort(arr: IntArray, from: Int, to: Int) {
        if (from < to) {
            val pivot = partition(arr, from, to)
            sort(arr, from, pivot)
            sort(arr, pivot + 1, to)
        }
    }

    private fun partition(arr: IntArray, from: Int, to: Int): Int {
        var pivot = from
        for (index in from until to - 1) {
            if (arr[index] < arr[to - 1]) {
                swap(arr, index, pivot++)
            }
        }
        swap(arr, pivot, to - 1)
        return pivot
    }

    private fun swap(arr: IntArray, index1: Int, index2: Int) {
        arr[index1] = arr[index2].also { arr[index2] = arr[index1] }
    }
}
