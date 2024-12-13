package twentyFour.day01

import java.io.File
import utils.getExample1FileFromDayNumber
import utils.getInputFileFromDayNumber

const val DAY_NUMBER = "01"
fun main() {
    println("part 1(example): " + totalDistanceBetweenLists(getExample1FileFromDayNumber(DAY_NUMBER, "2024")))
    println("part 1: " + totalDistanceBetweenLists(getInputFileFromDayNumber(DAY_NUMBER, "2024")))
    println("part 2(example): " + totalSimilarities(getExample1FileFromDayNumber(DAY_NUMBER, "2024")))
    println("part 2: " + totalSimilarities(getInputFileFromDayNumber(DAY_NUMBER, "2024")))
}

fun totalDistanceBetweenLists(input: File) = LocationRecord(input.readLines())
    .getLocations()
    .totalDistanceBetweenLists()

fun totalSimilarities(input: File) = LocationRecord(input.readLines())
    .getLocations()
    .totalSimilarities()
