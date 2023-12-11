package day10

class Coordinate(val row: Int, val column: Int) {

    fun getNorthCoordinate() = Coordinate(row - 1, column)
    fun getSouthCoordinate() = Coordinate(row + 1, column)
    fun getWestCoordinate() = Coordinate(row, column - 1)
    fun getEastCoordinate() = Coordinate(row, column + 1)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Coordinate) return false

        if (row != other.row) return false
        return column == other.column
    }

    override fun hashCode(): Int {
        var result = row
        result = 31 * result + column
        return result
    }


}