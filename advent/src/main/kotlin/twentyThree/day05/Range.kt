package twentyThree.day05

class Range (
    private val destination: Long,
    private val source: Long,
    private val rangeLength: Long,
) {
    fun isInRange(value: Long): Boolean {
        return value >= source && value < source + rangeLength
    }

    fun mapValue(value: Long): Long {
        return value - (source-destination)
    }
}
