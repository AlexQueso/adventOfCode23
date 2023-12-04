package day4

import utils.getExample1FileFromDayNumber
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
    val scratchCards = getOriginalCardList()
    val originalScratchCardList = getOriginalCardList()
    var index = 0
    while (index < scratchCards.size) {
        val cardMatchingNumbers = scratchCards[index].getCardMatchingNumbers()
        val cardId = scratchCards[index].id
        for (i in cardId until cardId + cardMatchingNumbers) {
            scratchCards.add(originalScratchCardList[i].copy())
        }
        index ++
    }
    return scratchCards.size
}

fun getOriginalCardList(): MutableList<Card> {
    val list = mutableListOf<Card>()
    getCardsInput().forEachLine {
        list.add(CardRecord(it).getCard())
    }
    return list
}

fun getCardsInput() = getInputFileFromDayNumber(DAY_NUMBER)
//fun getCardsInput() = getExample1FileFromDayNumber(DAY_NUMBER)