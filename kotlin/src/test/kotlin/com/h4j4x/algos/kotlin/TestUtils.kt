package com.h4j4x.algos.kotlin

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.DynamicTest
import java.util.*
import kotlin.random.Random

fun interface IntArrayCallback {
    fun modify(arr: IntArray)
}

object TestUtils {
    private val random = Random.Default

    private fun randomArray(n: Int): IntArray {
        val arr = IntArray(n)
        for (i in 0 until n) {
            arr[i] = random.nextInt()
        }
        return arr
    }

    fun arraySortTest(size: Int, title: String, callback: IntArrayCallback): DynamicTest {
        val arr = randomArray(size)
        val expected: IntArray = arr.copyOf(arr.size)
        Arrays.sort(expected)
        return DynamicTest.dynamicTest(title) {
            callback.modify(arr)
            assertArrayEquals(expected, arr)
        }
    }
}
