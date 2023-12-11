package day10

import utils.getExample1FileFromDayNumber
import utils.getInputFileFromDayNumber
import java.io.File

const val DAY = "10"

fun main() {
    println("part1(example): " + stepsToFarthestPoint(getExample1FileFromDayNumber(DAY)))
    println("part1(example): " + stepsToFarthestPoint(getInputFileFromDayNumber(DAY)))
}

fun stepsToFarthestPoint(input: File): Int {
    return MapRecord(input.readLines()).getMap().stepsToFarthestPoint()

}
