package com.h4j4x.algos.kotlin.sort

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import java.util.*
import kotlin.random.Random

class Tests {
    private val random = Random.Default

    @TestFactory
    fun testCountingSort() = testSort(Counting(), 0, 100, 1000)

    private fun testSort(sorter: Sorter, min: Int, max: Int, bigMax: Int): Collection<DynamicTest> {
        val results = mutableListOf<DynamicTest>()
        val title = "Test ${sorter.name()} sort"
        for (i in 2..99) {
            val arr = randomArray(i, min, max)
            val expected = arr.copyOf()
            Arrays.sort(expected)
            results.add(DynamicTest.dynamicTest("$title $i") {
                sorter.sort(arr)
                Assertions.assertArrayEquals(expected, arr)
            })
        }
        var i = 10_000
        while (i < 1_000_000) {
            val arr = randomArray(i, min, bigMax)
            val expected = arr.copyOf()
            Arrays.sort(expected)
            results.add(DynamicTest.dynamicTest("$title $i") {
                sorter.sort(arr)
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
