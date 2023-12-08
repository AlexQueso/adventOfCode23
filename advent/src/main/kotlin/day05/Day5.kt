package day05

import utils.getExample1FileFromDayNumber
import utils.getInputFileFromDayNumber
import java.io.File

const val DAY_NUMBER = "05"
fun main() {
    println("part 1(example): " + calculateLowestLocation(getExample1FileFromDayNumber(DAY_NUMBER)))
    println("part 1: " + calculateLowestLocation(getInputFileFromDayNumber(DAY_NUMBER)))
    println("part 2(example): " + calculateLowestLocationWithSeedRange(getExample1FileFromDayNumber(DAY_NUMBER)))
    println("part 2: " + calculateLowestLocationWithSeedRange(getInputFileFromDayNumber(DAY_NUMBER)))
}

fun calculateLowestLocation(input: File): Long {
    return AlmanacRecord(input.readLines()).getAlmanac().lowestLocation()
}

fun calculateLowestLocationWithSeedRange(input: File): Long {
    return AlmanacRecord(input.readLines()).getAlmanac().lowestLocationWithSeedRange()
}
