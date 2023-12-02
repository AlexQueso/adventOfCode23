package day1

import utils.getFileFromFileName
import utils.getInputFileFromDayNumber

fun main() {
    println("1: " + calculateCalibrationValuesSum())
    println("2: " + calculateCalibrationValuesSumWithSpelledDigits())
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

fun getCalibrationDocument() = getInputFileFromDayNumber(1)
