package solutions

import readFile

fun partOne(input: List<Int>) =
    input.windowed(2)
        .count { (first, second) -> first < second }


fun partTwo(input: List<Int>) =
        input.windowed(3)
            .windowed(2)
            .count {(first, second) -> first.sum() < second.sum()}

fun main() {

    val input = readFile("Day01")
    println(partOne(input))
    println(partTwo(input))

}