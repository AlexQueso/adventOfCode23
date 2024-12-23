package twentyThree.day07

import utils.getExample1FileFromDayNumber
import utils.getInputFileFromDayNumber
import java.io.File

const val DAY_NUMBER = "07"

fun main() {
    println("part 2(example): " + totalWinnings(getExample1FileFromDayNumber(DAY_NUMBER, "2023")))
    println("part 2: " + totalWinnings(getInputFileFromDayNumber(DAY_NUMBER, "2023")))
}

fun totalWinnings(input: File) = CamelCardsRecord(input.readLines())
    .getCamelCards()
    .totalWinnings()
