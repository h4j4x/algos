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
        val leftArray = arr.copyOfRange(from, mid)
        val rightArray = arr.copyOfRange(mid, to)
        var index = from
        var leftIndex = 0
        var rightIndex = 0
        while (leftIndex < leftArray.size && rightIndex < rightArray.size) {
            if (leftArray[leftIndex] < rightArray[rightIndex]) {
                arr[index++] = leftArray[leftIndex++]
            } else {
                arr[index++] = rightArray[rightIndex++]
            }
        }
        while (leftIndex < leftArray.size) {
            arr[index++] = leftArray[leftIndex++]
        }
        while (rightIndex < rightArray.size) {
            arr[index++] = rightArray[rightIndex++]
        }
    }
}
