package day5

import utils.getExample1FileFromDayNumber
import utils.getInputFileFromDayNumber
import java.io.File

const val DAY_NUMBER = 5
fun main() {
    println("part 1(example): " + calculateLowestLocation(getExample1FileFromDayNumber(DAY_NUMBER)))
    println("part 1: " + calculateLowestLocation(getInputFileFromDayNumber(DAY_NUMBER)))
    println("part 2: ")
}

fun calculateLowestLocation(input: File): Long {
    return AlmanacRecord(input.readLines()).getAlmanac().lowestLocation()
}
