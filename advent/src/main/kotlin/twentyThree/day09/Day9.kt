package twentyThree.day09

import utils.getExample1FileFromDayNumber
import utils.getInputFileFromDayNumber
import java.io.File

const val DAY_NUMBER = "09"
fun main() {
    println("part1(example): " + sumOfExtraLastValues(getExample1FileFromDayNumber(DAY_NUMBER, "2023")))
    println("part1: " + sumOfExtraLastValues(getInputFileFromDayNumber(DAY_NUMBER, "2023")))
    println("part2(example): " + sumOfExtraPreviousValues(getExample1FileFromDayNumber(DAY_NUMBER, "2023")))
    println("part2 " + sumOfExtraPreviousValues(getInputFileFromDayNumber(DAY_NUMBER, "2023")))
}

fun sumOfExtraLastValues(input: File): Int {
    return ReportRecord(input.readLines()).getReport().sumOfExtraLastValues()
}

fun sumOfExtraPreviousValues(input: File): Int {
    return ReportRecord(input.readLines()).getReport().sumOfExtraPreviousValues()
}

