package day09

import utils.getExample1FileFromDayNumber
import utils.getInputFileFromDayNumber
import java.io.File

const val DAY_NUMBER = "09"
fun main() {
    println("part1(example): " + sumOfExtraLastValues(getExample1FileFromDayNumber(DAY_NUMBER)))
    println("part1: " + sumOfExtraLastValues(getInputFileFromDayNumber(DAY_NUMBER)))
    println("part2(example): " + sumOfExtraPreviousValues(getExample1FileFromDayNumber(DAY_NUMBER)))
    println("part2 " + sumOfExtraPreviousValues(getInputFileFromDayNumber(DAY_NUMBER)))
}

fun sumOfExtraLastValues(input: File): Int {
    return ReportRecord(input.readLines()).getReport().sumOfExtraLastValues()
}

fun sumOfExtraPreviousValues(input: File): Int {
    return ReportRecord(input.readLines()).getReport().sumOfExtraPreviousValues()
}

