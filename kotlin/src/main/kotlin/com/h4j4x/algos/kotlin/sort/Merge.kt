package com.h4j4x.algos.kotlin.sort

class Merge : Sorter {
    override fun name() = "MERGE"

    override fun sort(arr: IntArray) {
        sort(arr, 0, arr.size)
    }

    private fun sort(arr: IntArray, from: Int, to: Int) {
        if (from < to - 1) {
            val mid = (from + to) / 2
            sort(arr, from, mid)
            sort(arr, mid, to)
            merge(arr, from, mid, to)
        }
    }

    private fun merge(arr: IntArray, from: Int, mid: Int, to: Int) {
        val leftArr = arr.copyOfRange(from, mid)
        val rightArr = arr.copyOfRange(mid, to)
        var arrIndex = from
        var leftIndex = 0
        var rightIndex = 0
        while (leftIndex < leftArr.size && rightIndex < rightArr.size) {
            if (leftArr[leftIndex] < rightArr[rightIndex]) {
                arr[arrIndex++] = leftArr[leftIndex++]
            } else {
                arr[arrIndex++] = rightArr[rightIndex++]
            }
        }
        while (leftIndex < leftArr.size) {
            arr[arrIndex++] = leftArr[leftIndex++]
        }
        while (rightIndex < rightArr.size) {
            arr[arrIndex++] = rightArr[rightIndex++]
        }
    }
}
