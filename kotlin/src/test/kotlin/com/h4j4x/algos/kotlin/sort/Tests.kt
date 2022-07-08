package com.h4j4x.algos.kotlin.sort

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.assertTimeout
import java.time.Duration
import java.util.*
import kotlin.random.Random

class Tests {
    private val random = Random.Default

    @TestFactory
    fun testCountingSort() = testSort(Counting(), 0, 100, 1000)

    @TestFactory
    fun testHeapSort() = testSort(Heap(), maxMillisTimeout = 250)

    @TestFactory
    fun testMergeSort() = testSort(Merge(), maxMillisTimeout = 200)

    @TestFactory
    fun testQuickSort() = testSort(Quick(), maxMillisTimeout = 100)

    private fun testSort(
        sorter: Sorter, min: Int = Int.MIN_VALUE,
        max: Int = Int.MAX_VALUE, bigMax: Int = Int.MAX_VALUE,
        minMillisTimeout: Long = 20, maxMillisTimeout: Long = 25
    ): Collection<DynamicTest> {
        val results = mutableListOf<DynamicTest>()
        val title = "Test ${sorter.name()} sort"
        for (i in 2..99) {
            val arr = randomArray(i, min, max)
            val expected = arr.copyOf()
            Arrays.sort(expected)
            results.add(DynamicTest.dynamicTest("$title $i") {
                assertTimeout(Duration.ofMillis(minMillisTimeout)) { sorter.sort(arr) }
                Assertions.assertArrayEquals(expected, arr)
            })
        }
        var i = 10_000
        while (i < 1_000_000) {
            val arr = randomArray(i, min, bigMax)
            val expected = arr.copyOf()
            Arrays.sort(expected)
            results.add(DynamicTest.dynamicTest("$title $i") {
                assertTimeout(Duration.ofMillis(maxMillisTimeout)) { sorter.sort(arr) }
                Assertions.assertArrayEquals(expected, arr)
            })
            i += 10_000
        }
        return results
    }

    private fun randomArray(total: Int, min: Int, max: Int): IntArray {
        val arr = IntArray(total)
        for (i in 0 until total) {
            arr[i] = random.nextInt(min, max)
        }
        return arr
    }
}
