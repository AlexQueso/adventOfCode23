package day5

const val SEEDS = "seeds"
const val SEED = "seed-"
const val SOIL = "soil"
const val FERTILIZER = "fertilizer"
const val WATER = "water"
const val LIGHT = "light"
const val TEMPERATURE = "temperature"
const val HUMIDITY = "humidity"

class Almanac (

) {
    val seeds = mutableListOf<Long>()
    val seedToSoilMap = Map()
    val soilToFertilizer = Map()
    val fertilizerToWater = Map()
    val waterToLight = Map()
    val lightToTemperature = Map()
    val temperatureToHumidity = Map()
    val humidityToLocation = Map()
    val seedLocations = mutableListOf<Long>()

    fun lowestLocation(): Long {
        seeds.forEach {
            val soil = seedToSoilMap.map(it)
            val fertilizer = soilToFertilizer.map(soil)
            val water = fertilizerToWater.map(fertilizer)
            val light = waterToLight.map(water)
            val temperature = lightToTemperature.map(light)
            val humidity = temperatureToHumidity.map(temperature)
            seedLocations.add(humidityToLocation.map(humidity))
        }
        return minimum(seedLocations)
    }

    private fun minimum(list: List<Long>): Long {
        var minimum = Long.MAX_VALUE
        list.forEach {
            if (it < minimum){
                minimum = it
            }
        }
        return minimum
    }
}


class AlmanacRecord(private val record: List<String>) {
    private val almanac = Almanac()
    fun getAlmanac(): Almanac {
        setSeeds()
        setMap(SEED, almanac.seedToSoilMap)
        setMap(SOIL, almanac.soilToFertilizer)
        setMap(FERTILIZER, almanac.fertilizerToWater)
        setMap(WATER, almanac.waterToLight)
        setMap(LIGHT, almanac.lightToTemperature)
        setMap(TEMPERATURE, almanac.temperatureToHumidity)
        setMap(HUMIDITY, almanac.humidityToLocation)
        return almanac
    }

    private fun setSeeds(){
        record[0]
            .replace("seeds: ", "")
            .split(" ")
            .forEach{
                almanac.seeds.add(it.toLong())
            }
    }

    private fun setMap(mapType: String, map: Map){
        for (index in record.indices) {
            if (record[index].startsWith(mapType)) {
                addElementsToMap(index+1, map)
            }
        }
    }

    private fun addElementsToMap(index: Int, map: Map) {
        var mapIndex = index
        while (mapIndex < record.size && record[mapIndex] != "" ) {
            map.addRange(record[mapIndex])
            mapIndex++
        }
    }

}