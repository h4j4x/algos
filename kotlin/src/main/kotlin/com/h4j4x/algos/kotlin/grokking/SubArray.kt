package com.h4j4x.algos.kotlin.grokking

object SubArray {
    fun smallestSubarrayWithGreaterSum(arr: IntArray, sum: Int): IntArray {
        var maxFrom = 0
        var maxTo = arr.lastIndex
        var from = 0
        var fromToSum = 0
        for (index in arr.indices) {
            fromToSum += arr[index]
            while (fromToSum >= sum) {
                if (index - from <= maxTo - maxFrom) {
                    maxFrom = from
                    maxTo = index
                }
                fromToSum -= arr[from]
                from++
            }
        }
        return IntArray(maxTo - maxFrom + 1) { arr[it + maxFrom] }
    }
}
