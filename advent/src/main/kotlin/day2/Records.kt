package day2

class GameRecord(private val record: String) {
    fun getGame(): Game {
        val gameId = filterGameIdData()
        return Game(
            id = gameId,
            subsets = getSubsets(gameId),
        )
    }

    private fun filterGameIdData() = record
        .replace("Game ",  "")
        .substring(0,3)
        .replace(":", "")
        .replace(" ", "")
        .toInt()

    private fun getSubsets(gameId: Int): MutableList<Subset> {
        val subsets = mutableListOf<Subset>()
        filterSubset(gameId)
            .split(";")
            .forEach {
                subsets.add(SubsetRecord(it).getSubset())
            }
        return subsets
    }

    private fun filterSubset(gameId: Int) : String{
        return if (gameId < 10) {
            record.substring(7)
        } else if (gameId < 100) {
            record.substring(8)
        } else {
            record.substring(9)
        }
    }
}

class SubsetRecord(private val record: String) {
    fun getSubset(): Subset {
        val subset = Subset()
        record.split(",").forEach {
            if (it.contains(RED)) {
                subset.red = filterColourNumber(it)
            }
            if (it.contains(BLUE)) {
                subset.blue = filterColourNumber(it)
            }
            if (it.contains(GREEN)) {
                subset.green = filterColourNumber(it)
            }
        }
        return subset
    }

    private fun filterColourNumber (colourLine: String) = colourLine
        .substring(1,3)
        .replace(" ", "")
        .toInt()
}