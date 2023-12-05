package day5

class Map(
    private val ranges: MutableList<Range> = mutableListOf()
) {
    fun addRange(rangeLine: String) {
        val source = rangeLine.split(" ")
        ranges.add(Range(source[0].toLong(), source[1].toLong(), source[2].toLong()))
    }

    fun map(value: Long): Long {
        ranges.forEach {
            if (it.isInRange(value)) {
                return it.mapValue(value)
            }
        }
        return value
    }
}
