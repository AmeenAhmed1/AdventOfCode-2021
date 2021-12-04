package solutions

import readFileString

object Day02 {

    fun partOne(input: List<String>): Int {

        var horizontal = 0
        var depth = 0

        val singleLine = input.map { it.split(' ') }

        for ((direction, unit) in singleLine) {
            val amount = unit.toInt()
            when (direction) {
                "forward" -> horizontal += amount
                "down" -> depth += amount
                "up" -> depth -= amount
            }
        }

        return horizontal * depth
    }


    fun partTwo(input: List<String>): Int {

        var horizontal = 0
        var depth = 0
        var aim = 0

        val singleLine = input.map { it.split(' ') }

        for ((direction, unit) in singleLine) {
            val amount = unit.toInt()
            when (direction) {
                "forward" -> {
                    horizontal += amount
                    depth += (amount * aim)
                }
                "down" -> aim += amount
                "up" -> aim -= amount
            }
        }

        return horizontal * depth
    }
}

fun main() {

    val input = readFileString("Day02")
    println(Day02.partOne(input))
    println(Day02.partTwo(input))

}