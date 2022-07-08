package com.h4j4x.algos.kotlin.sort

class Heap : Sorter {
    override fun name() = "HEAP"

    override fun sort(arr: IntArray) {
        for (index in arr.size / 2 - 1 downTo 0) {
            heapMaxArray(arr, index, arr.size)
        }
        for (index in arr.size - 1 downTo 1) {
            swap(arr, 0, index)
            heapMaxArray(arr, 0, index)
        }
    }

    private fun heapMaxArray(arr: IntArray, index: Int, toIndex: Int) {
        var maxIndex = index
        val leftIndex = index * 2 + 1
        val rightIndex = index * 2 + 2
        if (leftIndex < toIndex && arr[leftIndex] > arr[maxIndex]) {
            maxIndex = leftIndex
        }
        if (rightIndex < toIndex && arr[rightIndex] > arr[maxIndex]) {
            maxIndex = rightIndex
        }
        if (maxIndex != index) {
            swap(arr, maxIndex, index)
            heapMaxArray(arr, maxIndex, toIndex)
        }
    }

    private fun swap(arr: IntArray, index1: Int, index2: Int) {
        arr[index1] = arr[index2].also { arr[index2] = arr[index1] }
    }
}
