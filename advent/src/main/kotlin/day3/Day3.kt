package day3

import utils.getExample1FileFromDayNumber
import utils.getInputFileFromDayNumber

const val DAY_NUMBER = 3

fun main() {
    println("part 1: " + calculateSumOfPartNumbers())
    println("part 2: " + calculateSumOfGearRatios())
}

fun calculateSumOfPartNumbers(): Int {
    return getEngineFromInput().sumOfPartNumbers()
}

fun calculateSumOfGearRatios(): Int {
    return getEngineFromInput().sumOfGearRatios()
}

fun getEngineFromInput(): Engine {
    val engine = Engine()
//    getExample1FileFromDayNumber(DAY_NUMBER).forEachLine {
//        engine.addSchematicLine(it)
//    }
    getInputFileFromDayNumber(DAY_NUMBER).forEachLine {
        engine.addSchematicLine(it)
    }
    return engine
}
