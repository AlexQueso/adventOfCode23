package day2

import utils.getExample1FileFromDayNumber
import utils.getInputFileFromDayNumber
import java.io.File

const val DAY_NUMBER = 2
const val RED = "red"
const val BLUE = "blue"
const val GREEN = "green"

fun main() {
    println("problema 1: " + calculateSumOfPossibleGameIds())
    println("problema 2: " + calculateSumOfGamePowers())
}

fun calculateSumOfGamePowers() =
    createMatchFromRecord().sumOfGamePowers()

fun calculateSumOfPossibleGameIds() =
    createMatchFromRecord().sumOfPossibleGamesIds()

fun createMatchFromRecord(): Match {
    val match = Match()
    getGamesRecord().forEachLine {
        match.addGame(GameRecord(it).getGame())
    }
    return match
}

fun getGamesRecord() : File {
    return getInputFileFromDayNumber(DAY_NUMBER)
//    return getExample1FileFromDayNumber(DAY_NUMBER)
}

