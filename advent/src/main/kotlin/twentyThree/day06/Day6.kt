package twentyThree.day06

import utils.getExample1FileFromDayNumber
import utils.getInputFileFromDayNumber
import java.io.File

const val DAY_NUMBER = "06"
fun main() {
    println("part 1(example): " + numberOfWinningPossibilities(getExample1FileFromDayNumber(DAY_NUMBER, "2023")))
    println("part 1: " + numberOfWinningPossibilities(getInputFileFromDayNumber(DAY_NUMBER, "2023")))
    println("part 2(example): " + numberOfWinningPossibilitiesNoKerning(getExample1FileFromDayNumber(DAY_NUMBER, "2023")))
    println("part 2: " + numberOfWinningPossibilitiesNoKerning(getInputFileFromDayNumber(DAY_NUMBER, "2023")))
}

fun numberOfWinningPossibilitiesNoKerning(input: File) = CompetitionRecord(input.readLines())
        .getCompetitionNoKerning()
        .numberOfWinningPossibilities()

fun numberOfWinningPossibilities(input: File) = CompetitionRecord(input.readLines())
    .getCompetition()
    .numberOfWinningPossibilities()
