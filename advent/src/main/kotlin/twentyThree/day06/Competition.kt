package twentyThree.day06

const val TIMES = 0
const val DISTANCES = 1

class Competition(private val races: List<Race>) {

    fun numberOfWinningPossibilities(): Long {
        var numberOfWinningPossibilities : Long = 1
        races.forEach{
            numberOfWinningPossibilities *= it.numberOfWinningPossibilities()
        }
        return numberOfWinningPossibilities
    }
}

class CompetitionRecord(private val record: List<String>) {

    private val races = mutableListOf<Race>()

    fun getCompetition(): Competition {
        val times = getCompetitionParam(TIMES)
        val distances = getCompetitionParam(DISTANCES)
        setCompetitionParams(times, distances)
        return Competition(races)
    }

    private fun setCompetitionParams(times: List<Long>, distances: List<Long>) {
        times.forEachIndexed { index, time ->
            races.add(Race(time, distances[index]))
        }
    }

    private fun getCompetitionParam(param: Int): List<Long> {
        val params = mutableListOf<Long>()
        record[param]
            .substring(9)
            .chunked(7)
            .forEach {
                params.add(getLongValue(it))
            }
        return params
    }

    private fun getLongValue(line: String) = line
        .replace("   ", "")
        .replace("  ", "")
        .replace(" ", "")
        .toLong()

    fun getCompetitionNoKerning(): Competition {
        val times = getCompetitionParam(TIMES)
        val distances = getCompetitionParam(DISTANCES)
        val timeWithoutKerning = removeKerning(times)
        val distanceWithoutKerning = removeKerning(distances)
        races.add(Race(timeWithoutKerning, distanceWithoutKerning))
        return Competition(races)
    }

    private fun removeKerning(values: List<Long>): Long {
        var valueString = ""
        values.forEach{
            valueString += it
        }
        return valueString.toLong()
    }

}
