package twentyThree.day10

import utils.getExample1FileFromDayNumber
import utils.getInputFileFromDayNumber
import java.io.File

const val DAY = "10"

fun main() {
    println("part1(example): " + stepsToFarthestPoint(getExample1FileFromDayNumber(DAY, "2023")))
    println("part1(example): " + stepsToFarthestPoint(getInputFileFromDayNumber(DAY, "2023")))
}

fun stepsToFarthestPoint(input: File): Int {
    return MapRecord(input.readLines()).getMap().stepsToFarthestPoint()
}
