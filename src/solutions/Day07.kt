package solutions

import readFileString
import kotlin.math.absoluteValue

object Day07 {

    fun partOne(input: List<Int>): Int {

        val sortedInput = input.sorted()
        val inputSize = input.size
        val medianNumber =
            if (inputSize % 2 == 0)
                (sortedInput[inputSize / 2] + sortedInput[(inputSize / 2) - 1]) / 2
            else
                sortedInput[inputSize / 2]


        var minFuel = 0

        for (i in 0..inputSize - 1)
            minFuel += (sortedInput[i] - medianNumber).absoluteValue

        return minFuel
    }


    fun partTwo(input: List<String>) {}

}


fun main() {

    val input = readFileString("Day07").flatMap { it.split(",") }.map { it.toInt() }
    println(Day07.partOne(input))
    //println(Day07.partTwo(input))

}