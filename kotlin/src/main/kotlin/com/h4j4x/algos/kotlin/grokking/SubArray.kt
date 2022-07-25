package com.h4j4x.algos.kotlin.grokking

object SubArray {
    fun smallestSubarrayWithGreaterSum(arr: IntArray, sum: Int): IntArray {
        var maxFrom = 0
        var maxTo = arr.size
        var from = 0
        var indexSum = 0
        for (index in arr.indices) {
            indexSum += arr[index]
            while (indexSum >= sum) {
                if (index - from <= maxTo - maxFrom && indexSum >= sum) {
                    maxFrom = from
                    maxTo = index
                }
                indexSum -= arr[from]
                from++
            }
        }
        return arr.copyOfRange(maxFrom, maxTo + 1)
    }

    fun longestSubstringWithMaxKDistinctChars(str: String, distinctChars: Int): String {
        var from = 0
        var maxFrom = 0
        var maxTo = 0
        val countMap = mutableMapOf<Char, Int>()
        for (index in str.indices) {
            val char = str[index]
            countMap[char] = (countMap[char] ?: 0) + 1
            while (countMap.size > distinctChars) {
                val fromChar = str[from]
                countMap[fromChar] = countMap[fromChar]!! - 1
                if (countMap[fromChar] == 0) {
                    countMap.remove(fromChar)
                }
                from++
            }
            if (index - from >= maxTo - maxFrom) {
                maxFrom = from
                maxTo = index
            }
        }
        return str.substring(maxFrom, maxTo + 1)
    }
}
