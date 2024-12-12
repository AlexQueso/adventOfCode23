package twentyThree.day11

import kotlin.math.abs

class Coordinate(private val row: Long, private val column: Long) {

    fun distanceToCoordinate(coordinate: Coordinate) : Long {
        return abs(row - coordinate.row) + abs(column - coordinate.column)
    }

}