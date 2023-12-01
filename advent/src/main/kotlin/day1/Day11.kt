package day1

import utils.getFileFromFileName

const val INPUT_URL = "src/main/resources/day1/input.txt"

fun main() {
    println(calculateCalibrationValuesSum())
}

fun calculateCalibrationValuesSum(): Int {
    var calibrationValuesSum = 0
    getFileFromFileName(INPUT_URL).forEachLine {
        calibrationValuesSum += (calculateCalibrationValue(it))
    }
    return calibrationValuesSum
}

fun calculateCalibrationValue(textLine: String): Int {
    return getFirstDigit(textLine) * 10 + getLastDigit(textLine)
}

fun getFirstDigit(line: String): Int {
    line.toCharArray().forEach {
        if (it.isDigit()) {
            return it.digitToInt()
        }
    }
    throw NoDigitInLineFoundException("")
}

fun getLastDigit(line: String): Int {
    val reversedLine = line.reversed()
    return getFirstDigit(reversedLine)
}
