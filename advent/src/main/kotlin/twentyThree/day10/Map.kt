package twentyThree.day10

class Map(private val grid: List<List<Tile>>) {

    private val maxColumns = grid[0].size - 1
    private val maxRows = grid.size - 1
    private val initialTile = findInitialTile()
    private val mainLoop = mutableListOf<Tile>()

    fun stepsToFarthestPoint(): Int {
        updateInitialTileConnections()
        findMainLoopElements()
        return mainLoop.size/2
    }

    private fun findMainLoopElements() {
        mainLoop.add(initialTile)
        var currentTile = getNextTile(initialTile)
        while (currentTile.pipe != "S") {
            val nextTile = getNextTile(currentTile)
            mainLoop.add(currentTile)
            currentTile = nextTile
        }
    }

    private fun getNextTile(currentTile: Tile): Tile {
        return if (currentTile.pipe == "S") {
            getTile(currentTile.connections[0])
        } else {
            if (currentTile.connections[0] != mainLoop.last().coordinate) {
                getTile(currentTile.connections[0])
            } else{
                getTile(currentTile.connections[1])
            }
        }
    }

    private fun findInitialTile(): Tile {
        return grid
            .flatten()
            .first { it.pipe == "S" }
    }

    private fun updateInitialTileConnections() {
        addInitialTileEastConnection()
        addInitialTileWestConnection()
        addInitialTileNorthConnection()
        addInitialTileSouthConnection()
    }

    private fun addInitialTileNorthConnection() {
        if (initialTile.connections.size < 2 && initialTile.getRow() > 0) {
            val northTile = getTile(initialTile.coordinate.getNorthCoordinate())
            if ((northTile.pipe == "|") || (northTile.pipe == "7") || (northTile.pipe == "F")) {
                initialTile.connections.add(northTile.coordinate)
            }
        }
    }

    private fun addInitialTileSouthConnection() {
        if (initialTile.connections.size < 2 && initialTile.getRow() < maxRows) {
            val southTile = getTile(initialTile.coordinate.getSouthCoordinate())
            if ((southTile.pipe == "|") || (southTile.pipe == "J") || (southTile.pipe == "L")) {
                initialTile.connections.add(southTile.coordinate)
            }
        }
    }

    private fun addInitialTileWestConnection() {
        if (initialTile.connections.size < 2 && initialTile.getColumn() > 0) {
            val westTile = getTile(initialTile.coordinate.getWestCoordinate())
            if ((westTile.pipe == "-") || (westTile.pipe == "L") || (westTile.pipe == "F")) {
                initialTile.connections.add(westTile.coordinate)
            }
        }
    }

    private fun addInitialTileEastConnection() {
        if (initialTile.connections.size < 2 && initialTile.getColumn() < maxColumns) {
            val eastTile = getTile(initialTile.coordinate.getEastCoordinate())
            if ((eastTile.pipe == "-") || (eastTile.pipe == "7") || (eastTile.pipe == "J")) {
                initialTile.connections.add(eastTile.coordinate)
            }
        }
    }

    private fun getTile(coordinate: Coordinate) = grid[coordinate.row][coordinate.column]
}

class MapRecord(private val record: List<String>) {

    private val grid: MutableList<MutableList<Tile>> = mutableListOf()
    fun getMap(): Map {
        record.forEachIndexed { rowIndex, rowRecord ->
            val row = mutableListOf<Tile>()
            rowRecord.chunked(1).forEachIndexed { columnIndex, tile ->
                row.add(Tile(tile, Coordinate(rowIndex, columnIndex)))
            }
            grid.add(row)
        }
        return Map(grid)
    }
}
