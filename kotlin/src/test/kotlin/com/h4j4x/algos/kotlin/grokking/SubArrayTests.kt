package com.h4j4x.algos.kotlin.grokking

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
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

    @Test
    fun testLongestSubstringWithMaxKDistinctChars() {
        var subString = SubArray.longestSubstringWithMaxKDistinctChars("araaci", 2)
        assertEquals("araa", subString)

        subString = SubArray.longestSubstringWithMaxKDistinctChars("araaci", 1)
        assertEquals("aa", subString)

        subString = SubArray.longestSubstringWithMaxKDistinctChars("cbbebi", 3)
        assertEquals("bbebi", subString)

        subString = SubArray.longestSubstringWithMaxKDistinctChars("cbbebi", 10)
        assertEquals("cbbebi", subString)
    }
}
