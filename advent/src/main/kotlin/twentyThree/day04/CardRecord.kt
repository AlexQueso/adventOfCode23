package twentyThree.day04

class CardRecord(private val line: String) {

    fun getCard() = Card(getId(), getWinningNumbers(), getPotentialNumbers())

    private fun getId(): Int {
        return line
            .substring(5, 8)
            .replace("  ", "")
            .replace(" ", "")
            .toInt()
    }

    private fun getPotentialNumbers() = mapToIntList(filterPotentialNumbersLine())

    private fun getWinningNumbers() = mapToIntList( filterWinningNumbersLine())

    private fun mapToIntList(numbersLine: String): List<Int> {
        val intList = mutableListOf<Int>()
        numbersLine
            .split(" ")
            .forEach {
                if (it != ""){
                    intList.add(mapToInt(it))
                }
            }
        return intList
    }

    private fun mapToInt(numberString: String) = numberString.replace(" ", "").toInt()

    private fun filterWinningNumbersLine(): String {
        return line
            .substring(10)
            .split("|")[0]
    }

    private fun filterPotentialNumbersLine(): String {
        return line
            .substring(10)
            .split("|")[1]
    }
}