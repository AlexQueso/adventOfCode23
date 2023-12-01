package day1

import utils.getFileFromFileName

const val ONE = "one"
const val TWO = "two"
const val THREE = "three"
const val FOUR = "four"
const val FIVE = "five"
const val SIX = "six"
const val SEVEN = "seven"
const val EIGHT = "eight"
const val NINE = "nine"

const val EXAMPLE_2_URL = "src/main/resources/day1/example2.txt"

fun main() {
    println(calculateCalibrationValuesSumWithSpelledDigits())
}

fun calculateCalibrationValuesSumWithSpelledDigits(): Int {
    var calibrationValuesSum = 0
    getFileFromFileName(INPUT_URL).forEachLine {
        calibrationValuesSum += (calculateCalibrationValueWithSpelledDigits(it))
    }
    return calibrationValuesSum
}

fun calculateCalibrationValueWithSpelledDigits(textLine: String): Int {
    val spelledDigitsTextLine = switchSpelledDigitsWithActualDigits(textLine)
    return getFirstDigit(spelledDigitsTextLine) * 10 + getLastDigit(spelledDigitsTextLine)
}

fun switchSpelledDigitsWithActualDigits(textLine: String): String {
    var updatedLine = textLine.replace(ONE, "o1ne")
    updatedLine = updatedLine.replace(TWO, "t2wo")
    updatedLine = updatedLine.replace(THREE, "thr3ee")
    updatedLine = updatedLine.replace(FOUR, "fo4ur")
    updatedLine = updatedLine.replace(FIVE, "fi5ve")
    updatedLine = updatedLine.replace(SIX, "si6x")
    updatedLine = updatedLine.replace(SEVEN, "se7ven")
    updatedLine = updatedLine.replace(EIGHT, "ei8ght")
    return updatedLine.replace(NINE, "n9ine")
}
