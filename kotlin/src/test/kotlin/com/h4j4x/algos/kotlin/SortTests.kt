package com.h4j4x.algos.kotlin

import com.h4j4x.algos.kotlin.sort.Counting
import com.h4j4x.algos.kotlin.sort.Sorter
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

class SortTests {
    private val sorters = listOf<Sorter>(Counting())

    @TestFactory
    fun testIntArraySort(): Collection<DynamicTest> {
        val result: MutableList<DynamicTest> = ArrayList()
        for (i in 0..99) {
            for (sorter in sorters) {
                result.add(TestUtils.arraySortTest(i, "Test ${sorter.name()} sort $i", sorter::sort))
            }
        }
        var i = 10000
        while (i < 1000000) {
            for (sorter in sorters) {
                result.add(TestUtils.arraySortTest(i, "Test ${sorter.name()} sort $i", sorter::sort))
            }
            i += 10000
        }
        return result
    }
}