package twentyThree.day04

import utils.getInputFileFromDayNumber

const val DAY_NUMBER = "04"
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

fun getCardsInput() = getInputFileFromDayNumber(DAY_NUMBER, "2023")
//fun getCardsInput() = getExample1FileFromDayNumber(DAY_NUMBER)