package solutions

import readFileString


object Day05 {

    fun fishLantern(input: List<Int>): Int {

        val lanternState = mutableListOf<Int>()
        lanternState.addAll(input)

        //Repeat as days as you need
        repeat(80) {
            for (i in 0..lanternState.size - 1) {
                if (lanternState[i] == 0) {
                    lanternState[i] = 6
                    lanternState.add(8)
                } else lanternState[i]--
            }
            //println(lanternState)
        }

        return lanternState.size
    }


    fun getFishLanternNumber(input: List<Int>): Long {
        val counter = LongArray(9)
        input.forEach { counter[it]++ }

        repeat(256) {
            val willCreateNew = counter[0]
            for (i in 1..8) counter[i - 1] = counter[i]
            counter[6] += willCreateNew
            counter[8] = willCreateNew
        }

        return counter.sum()
    }
}

fun main() {
    val input = readFileString("Day06")
        .flatMap { it.split(",") }
        .map { it.toInt() }

    println(Day05.fishLantern(input))
    println(Day05.getFishLanternNumber(input))
}