package twentyThree.day03

import utils.getInputFileFromDayNumber

const val DAY_NUMBER = "03"

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
    getInputFileFromDayNumber(DAY_NUMBER, "2023").forEachLine {
        engine.addSchematicLine(it)
    }
    return engine
}
