package com.h4j4x.algos.kotlin.sort

class Heap : Sorter {
    override fun name() = "HEAP"

    override fun sort(arr: IntArray) {
        val len = arr.size
        for (index in len / 2 - 1 downTo 0) {
            heapMaxArray(arr, index, len)
        }
        for (index in len - 1 downTo 1) {
            swap(arr, 0, index)
            heapMaxArray(arr, 0, index)
        }
    }

    private fun heapMaxArray(arr: IntArray, index: Int, toIndex: Int) {
        var maxIndex = index
        val leftChildIndex = index * 2 + 1
        if (leftChildIndex < toIndex && arr[leftChildIndex] > arr[maxIndex]) {
            maxIndex = leftChildIndex
        }
        val rightChildIndex = index * 2 + 2
        if (rightChildIndex < toIndex && arr[rightChildIndex] > arr[maxIndex]) {
            maxIndex = rightChildIndex
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
