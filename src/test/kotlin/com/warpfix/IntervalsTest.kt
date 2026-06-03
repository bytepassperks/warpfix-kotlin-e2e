package com.warpfix

import kotlin.test.Test
import kotlin.test.assertEquals

class IntervalsTest {
    @Test
    fun `merges touching intervals into one`() {
        // (1,3) touches (3,5) at the boundary 3 -> must collapse to (1,5)
        assertEquals(listOf(1 to 5), Intervals.mergeIntervals(listOf(1 to 3, 3 to 5)))
    }

    @Test
    fun `merges overlapping intervals`() {
        assertEquals(listOf(1 to 6), Intervals.mergeIntervals(listOf(1 to 4, 2 to 6)))
    }

    @Test
    fun `keeps disjoint intervals separate`() {
        assertEquals(listOf(1 to 2, 5 to 7), Intervals.mergeIntervals(listOf(1 to 2, 5 to 7)))
    }
}
