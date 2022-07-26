package com.h4j4x.algos.kotlin.grokking

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SlidingWindowTests {
    @Test
    fun testSmallestSubarrayWithGreaterSum() {
        var subarray = SlidingWindow.smallestSubarrayWithGreaterSum(intArrayOf(2, 1, 5, 2, 3, 2), 7)
        assertArrayEquals(intArrayOf(5, 2), subarray)

        subarray = SlidingWindow.smallestSubarrayWithGreaterSum(intArrayOf(2, 1, 5, 2, 8), 7)
        assertArrayEquals(intArrayOf(8), subarray)

        subarray = SlidingWindow.smallestSubarrayWithGreaterSum(intArrayOf(3, 4, 1, 1, 6), 8)
        assertArrayEquals(intArrayOf(1, 1, 6), subarray)
    }

    @Test
    fun testLongestSubstringWithMaxKDistinctChars() {
        var subString = SlidingWindow.longestSubstringWithMaxKDistinctChars("araaci", 2)
        assertEquals("araa", subString)

        subString = SlidingWindow.longestSubstringWithMaxKDistinctChars("araaci", 1)
        assertEquals("aa", subString)

        subString = SlidingWindow.longestSubstringWithMaxKDistinctChars("cbbebi", 3)
        assertEquals("bbebi", subString)

        subString = SlidingWindow.longestSubstringWithMaxKDistinctChars("cbbebi", 10)
        assertEquals("cbbebi", subString)
    }

    @Test
    fun testNoRepeatSubstring() {
        var subString = SlidingWindow.noRepeatSubstring("aabccbb")
        assertEquals("abc", subString)

        subString = SlidingWindow.noRepeatSubstring("abbbb")
        assertEquals("ab", subString)

        subString = SlidingWindow.noRepeatSubstring("abccde")
        assertEquals("cde", subString)
    }
}
