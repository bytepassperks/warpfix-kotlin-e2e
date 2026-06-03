package com.warpfix

/**
 * Interval utilities for the scheduling layer.
 *
 * [mergeIntervals] collapses a list of (start, end) ranges into the smallest set
 * of non-overlapping ranges. Touching ranges — where one ends exactly where the
 * next begins, e.g. (1, 3) and (3, 5) — are contiguous and must merge into a
 * single range (1, 5).
 */
object Intervals {
    fun mergeIntervals(intervals: List<Pair<Int, Int>>): List<Pair<Int, Int>> {
        if (intervals.isEmpty()) return emptyList()

        val ordered = intervals.sortedBy { it.first }
        val merged = mutableListOf(ordered.first())

        for (current in ordered.drop(1)) {
            val last = merged.last()
            // BUG: a strict `<` leaves touching intervals (start == last.end)
            // unmerged; boundaries are inclusive, so this must be `<=`.
            if (current.first < last.second) {
                merged[merged.size - 1] = last.first to maxOf(last.second, current.second)
            } else {
                merged.add(current)
            }
        }
        return merged
    }
}
