package solutions

import com.sun.org.apache.xpath.internal.operations.Bool
import readFileString

object Day04 {
    fun partOne(input: List<String>): Int {
        val numbers = getNumberFromInput(input)
        val boards = getBoardsFromInput(input)

        val currentNumbers = mutableSetOf<Int>()
        for (num in numbers) {
            currentNumbers.add(num)
            boards.firstOrNull { isBingoWins(it, currentNumbers) }?.let { return winScore(it, currentNumbers) }
        }
        return 0
    }


    fun partTwo(input: List<String>): Int {
        val numbers = getNumberFromInput(input)
        var boards = getBoardsFromInput(input)

        val currentNumbers = mutableSetOf<Int>()
        for (num in numbers) {
            currentNumbers.add(num)
            if (boards.size == 1) boards.firstOrNull { isBingoWins(it, currentNumbers) }?.let {
                return winScore(
                    it,
                    currentNumbers
                )
            }
            else boards = boards.filter { !isBingoWins(it, currentNumbers) }.toList()
        }
        return 0
    }

}


private fun isBingoWins(board: List<Int>, numbers: Set<Int>): Boolean {

    for (i in 0..4) {

        val index = i * 5

        val row = listOf(board[index], board[index + 1], board[index + 2], board[index + 3], board[index + 4])
        if (numbers.containsAll(row)) return true

        val column = listOf(board[i], board[i + 5], board[i + 10], board[i + 15], board[i + 20])
        if (numbers.containsAll(column)) return true

    }

    return false
}

private fun winScore(board: List<Int>, numbers: Set<Int>) = (board - numbers).sum() * numbers.last()

private fun getNumberFromInput(input: List<String>) = input[0].split(",").map { it.toInt() }
private fun getBoardsFromInput(input: List<String>) = input.drop(2)
    .chunked(6)
    .map {
        it.take(5)
            .flatMap { it.split("""\s+""".toRegex()) }
            .map { it.toInt() }
    }.toList()

fun main() {

    val input = readFileString("Day04").map { it.trim() }
    println(Day04.partOne(input))
    println(Day04.partTwo(input))

}