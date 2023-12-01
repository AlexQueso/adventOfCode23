package day1

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
    getCalibrationDocument().forEachLine {
        calibrationValuesSum += Line(it).retrieveCalibrationValueWithSpelledDigits()
    }
    return calibrationValuesSum
}
