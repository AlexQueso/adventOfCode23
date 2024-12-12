package twentyThree.day10

class Tile(val pipe: String, val coordinate: Coordinate) {

    val connections: MutableList<Coordinate> = calculateConnections()
    private fun calculateConnections(): MutableList<Coordinate> {
        return if (pipe == "|") {
            mutableListOf(coordinate.getNorthCoordinate(), coordinate.getSouthCoordinate())
        } else if (pipe == "-") {
            mutableListOf(coordinate.getWestCoordinate(), coordinate.getEastCoordinate())
        } else if (pipe == "L") {
            mutableListOf(coordinate.getNorthCoordinate(), coordinate.getEastCoordinate())
        } else if (pipe == "J") {
            mutableListOf(coordinate.getNorthCoordinate(), coordinate.getWestCoordinate())
        } else if (pipe == "7") {
            mutableListOf(coordinate.getSouthCoordinate(), coordinate.getWestCoordinate())
        } else if (pipe == "F") {
            mutableListOf(coordinate.getSouthCoordinate(), coordinate.getEastCoordinate())
        } else {
            mutableListOf()
        }
    }

    fun getRow() = coordinate.row
    fun getColumn() = coordinate.column
}