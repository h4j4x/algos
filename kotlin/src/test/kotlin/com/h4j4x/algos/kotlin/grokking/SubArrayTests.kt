package com.h4j4x.algos.kotlin.grokking

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class SubArrayTests {
    @Test
    fun testSmallestSubarrayWithGreaterSum() {
        var subarray = SubArray.smallestSubarrayWithGreaterSum(intArrayOf(2, 1, 5, 2, 3, 2), 7)
        assertArrayEquals(intArrayOf(5, 2), subarray)

        subarray = SubArray.smallestSubarrayWithGreaterSum(intArrayOf(2, 1, 5, 2, 8), 7)
        assertArrayEquals(intArrayOf(8), subarray)

        subarray = SubArray.smallestSubarrayWithGreaterSum(intArrayOf(3, 4, 1, 1, 6), 8)
        assertArrayEquals(intArrayOf(1, 1, 6), subarray)
    }
}
