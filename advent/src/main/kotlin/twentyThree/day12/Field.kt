package twentyThree.day12

class Field(private val rows : List<Row>) {
    fun sumOfPossibleArrangements(): Int {
        var sum = 0
        rows.forEach { sum += it.getPossibilities() }
        return sum
    }
}