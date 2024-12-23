package twentyThree.day01

import utils.getInputFileFromDayNumber

fun main() {
    println("part 1: " + calculateCalibrationValuesSum())
    println("part 2: " + calculateCalibrationValuesSumWithSpelledDigits())
}

fun calculateCalibrationValuesSum(): Int {
    var calibrationValuesSum = 0
    getCalibrationDocument().forEachLine {
        calibrationValuesSum += Line(it).retrieveCalibrationValue()
    }
    return calibrationValuesSum
}

fun calculateCalibrationValuesSumWithSpelledDigits(): Int {
    var calibrationValuesSum = 0
    getCalibrationDocument().forEachLine {
        calibrationValuesSum += Line(it).retrieveCalibrationValueWithSpelledDigits()
    }
    return calibrationValuesSum
}

fun getCalibrationDocument() = getInputFileFromDayNumber("01", "2023")
