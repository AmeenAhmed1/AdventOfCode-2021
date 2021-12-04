package solutions

import readFile

object Day01 {
    fun partOne(input: List<Int>) =
        input.windowed(2)
            .count { (first, second) -> first < second }


    fun partTwo(input: List<Int>) =
        input.windowed(3)
            .windowed(2)
            .count { (first, second) -> first.sum() < second.sum() }

}

fun main() {

    val input = readFile("Day01")
    println(Day01.partOne(input))
    println(Day01.partTwo(input))

}