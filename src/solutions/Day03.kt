package solutions

import readFileString

object Day03 {

    fun partOne(input: List<String>): Int {
        var gamma = ""
        var epsilon = ""

        for (index in 0..input.get(0).length - 1) {
            var ones = 0
            var zeros = 0

            for (iteration in 0..input.size - 1) {
                if (input[iteration].get(index).equals('1')) ones++
                else zeros++
            }
            if (ones > zeros) {
                gamma += '1'
                epsilon += '0'
            } else {
                gamma += '0'
                epsilon += '1'
            }
        }

        return Integer.parseInt(gamma, 2) * Integer.parseInt(epsilon, 2)
    }


    fun partTwo(input: List<String>) : Int {

        var remOXList: List<String> = input
        var remCOList: List<String> = input

        while (remOXList.size > 1) {

            for (index in remOXList.get(0).indices) {

                var ones = 0
                var zeros = 0

                for (iteration in remOXList.indices) {
                    when (remOXList[iteration].get(index)) {
                        '0' -> zeros++
                        '1' -> ones++
                    }
                }

                val whichOXKeep =
                    if (ones >= zeros) '1' else '0'

                val whichCOKeep =
                    if (ones >= zeros) '0' else '1'

                if (remOXList.size > 1) remOXList = remOXList.filter { it[index] == whichOXKeep }
                if (remCOList.size > 1) remCOList = remCOList.filter { it[index] == whichCOKeep }

            }
        }

        println(remOXList.first().toInt(2))
        println(remCOList.first().toInt(2))
        return remOXList.first().toInt(2) * remCOList.first().toInt(2)
    }
}

fun main() {

    val input = readFileString("Day03")
    println(Day03.partOne(input))
    println(Day03.partTwo(input))

}