package day4

import utils.getInputFileFromDayNumber

const val DAY_NUMBER = 4
fun main() {
    println("part 1: " + calculateWinningPoints())
    println("part 2: " + getScratchCardsAmount())
}

fun calculateWinningPoints(): Int {
    var totalPoints = 0
    getCardsInput().forEachLine {
        totalPoints += CardRecord(it).getCard().getCardPoints()
    }
    return totalPoints
}

fun getScratchCardsAmount(): Int {
    return CardGame(getCardsInput()).scratchCardsAmount()
}

fun getCardsInput() = getInputFileFromDayNumber(DAY_NUMBER)
//fun getCardsInput() = getExample1FileFromDayNumber(DAY_NUMBER)