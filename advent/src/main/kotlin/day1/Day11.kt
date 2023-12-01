package day1

import utils.getFileFromFileName

const val INPUT_URL = "src/main/resources/day1/input.txt"

fun main() {
    println(calculateCalibrationValuesSum())
}

fun calculateCalibrationValuesSum(): Int {
    var calibrationValuesSum = 0
    getCalibrationDocument().forEachLine {
        calibrationValuesSum += Line(it).retrieveCalibrationValue()
    }
    return calibrationValuesSum
}
fun getCalibrationDocument() = getFileFromFileName(INPUT_URL)
