package day1

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
