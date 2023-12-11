package day11

import utils.getExample1FileFromDayNumber
import utils.getInputFileFromDayNumber
import java.io.File

const val DAY = "11"

fun main() {
    println("part1(example): " + sumOfDistancesBetweenPairsOfGalaxies(getExample1FileFromDayNumber(DAY), 0))
    println("part1: " + sumOfDistancesBetweenPairsOfGalaxies(getInputFileFromDayNumber(DAY), 0))
    println("part2(example): " + sumOfDistancesBetweenPairsOfGalaxies(getExample1FileFromDayNumber(DAY),  100))
    println("part2: " + sumOfDistancesBetweenPairsOfGalaxies(getInputFileFromDayNumber(DAY), 1000000))
}

fun sumOfDistancesBetweenPairsOfGalaxies(input: File, expansionFactor: Int): Long {
    return SkyRecord(input.readLines()).getSky().sumOfDistancesBetweenPairsOfGalaxies(expansionFactor)
}
