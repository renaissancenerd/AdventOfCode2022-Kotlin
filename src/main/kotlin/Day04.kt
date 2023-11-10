/**
 * Advent of Code 2022, Day 4 - Camp Cleanup
 * Problem Description: http://adventofcode.com/2022/day/4
 */


class Day04(input: List<String>) {

    private val ranges: List<Pair<IntRange,IntRange>> = input.map { it.asRanges() }

    fun solvePart1(): Int =
        ranges.count { it.first fullyOverlaps it.second || it.second fullyOverlaps it.first  }

    fun solvePart2(): Int =
        ranges.count { it.first overlaps it.second }

    private infix fun IntRange.fullyOverlaps(other: IntRange): Boolean =
        first <= other.first && last >= other.last

    private infix fun IntRange.overlaps(other: IntRange): Boolean =
        first <= other.last && other.first <= last

    private fun String.asRanges(): Pair<IntRange,IntRange> =
        substringBefore(",").asIntRange() to substringAfter(",").asIntRange()

    private fun String.asIntRange(): IntRange =
        substringBefore("-").toInt() .. substringAfter("-").toInt()

}