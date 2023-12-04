package day4

import kotlin.math.pow

data class Card(
    val id: Int,
    private val winningNumbers: List<Int>,
    private val potentialNumbers: List<Int>,
) {

    private var matchingNumbers = 0
    fun getCardPoints(): Int {
        winningNumbers.forEach { winningNumber ->
            if (potentialNumbers.contains(winningNumber)) {
                matchingNumbers++
            }
        }
        return calculateWinningPoints()
    }

    fun getCardMatchingNumbers(): Int {
        winningNumbers.forEach { winningNumber ->
            if (potentialNumbers.contains(winningNumber)) {
                matchingNumbers++
            }
        }
        return matchingNumbers
    }

    private fun calculateWinningPoints() : Int {
        return 2.0.pow((matchingNumbers - 1).toDouble()).toInt()
    }

}
