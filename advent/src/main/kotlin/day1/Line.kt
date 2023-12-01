package day1

class Line(private val line: String) {

    fun retrieveCalibrationValue() = getFirstDigit() + getLastDigit()

    fun retrieveCalibrationValueWithSpelledDigits(): Int {
        val lineWithActualDigits = includeActualDigitsWhenSpelled()
        return Line(lineWithActualDigits).retrieveCalibrationValue()
    }

    private fun getFirstDigit(): Int {
        line.toCharArray().forEach {
            if (it.isDigit()) {
                return it.digitToInt() * 10
            }
        }
        throw NoDigitInLineFoundException(line)
    }

    private fun getLastDigit(): Int {
        line.reversed().toCharArray().forEach {
            if (it.isDigit()) {
                return it.digitToInt()
            }
        }
        throw NoDigitInLineFoundException(line)
    }

    private fun includeActualDigitsWhenSpelled(): String {
        return line.replace(ONE, "o1ne")
            .replace(TWO, "t2wo")
            .replace(THREE, "t3hree")
            .replace(FOUR, "f4our")
            .replace(FIVE, "f5ive")
            .replace(SIX, "s6ix")
            .replace(SEVEN, "s7even")
            .replace(EIGHT, "e8ight")
            .replace(NINE, "n9ine")
    }
}