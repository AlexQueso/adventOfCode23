package day7

import utils.getExample1FileFromDayNumber
import utils.getInputFileFromDayNumber
import java.io.File

const val DAY_NUMBER = 7

fun main() {
    println("part 2(example): " + totalWinnings(getExample1FileFromDayNumber(DAY_NUMBER)))
    println("part 2: " + totalWinnings(getInputFileFromDayNumber(DAY_NUMBER)))
}

fun totalWinnings(input: File) = CamelCardsRecord(input.readLines())
    .getCamelCards()
    .totalWinnings()
