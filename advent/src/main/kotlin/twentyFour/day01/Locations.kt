package twentyFour.day01

import kotlin.math.abs

class Locations(private val locationList: List<MutableList<Int>>) {

    private val similarities = mutableMapOf<Int, Int>()

    fun totalDistanceBetweenLists(): Int {
        val sortedLocations = locationList.map { it.sorted() }

        return sortedLocations[0].indices.sumOf { i ->
            getPairDistance(sortedLocations[0][i], sortedLocations[1][i])
        }
    }

    private fun getPairDistance(location1: Int, location2: Int): Int {
        return abs(location1 - location2)
    }

    fun totalSimilarities(): Int {
        var totalSimilarities = 0
        locationList[0].forEach { location ->
            totalSimilarities += similarities.getOrPut(location) { calculateTotalAppearance(location) }
        }
        return totalSimilarities
    }

    private fun calculateTotalAppearance(location: Int) = (locationList[1].filter { it == location }.size) * location
}

class LocationRecord(private val record: List<String>) {

    private val locations = mutableListOf(mutableListOf<Int>(), mutableListOf())

    fun getLocations(): Locations {
        record.forEach {
            val locationsInLine = it.split("   ")
            locations[0].add(locationsInLine[0].toInt())
            locations[1].add(locationsInLine[1].toInt())
        }
        return Locations(locations)
    }
}