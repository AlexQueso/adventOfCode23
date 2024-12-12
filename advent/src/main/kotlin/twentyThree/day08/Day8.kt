package twentyThree.day08

import utils.getExample1FileFromDayNumber
import utils.getExample2FileFromDayNumber
import utils.getInputFileFromDayNumber
import java.io.File

const val DAY_NUMBER = "08"

fun main(){
    println("part1(example): " + stepsToZZZ(getExample1FileFromDayNumber(DAY_NUMBER, "2023")))
    println("part1: " + stepsToZZZ(getInputFileFromDayNumber(DAY_NUMBER, "2023")))
    println("part2(example): " + ghostStepsToXXZ(getExample2FileFromDayNumber(DAY_NUMBER, "2023")))
    println("part2(example): " + ghostStepsToXXZ(getInputFileFromDayNumber(DAY_NUMBER, "2023")))
}

fun stepsToZZZ(input: File): Long {
    return NavigationRecord(input.readLines()).getNavigation().stepsToZZZ()
}

fun ghostStepsToXXZ(input: File): Long {
    return NavigationRecord(input.readLines()).getNavigation().ghostStepsToXXZ()
}

