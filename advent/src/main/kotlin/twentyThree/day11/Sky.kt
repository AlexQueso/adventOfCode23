package twentyThree.day11

class Sky(private val universe: MutableList<MutableList<String>>) {

    private val galaxies = mutableListOf<Coordinate>()
    private var expansionFactor = 0
    fun sumOfDistancesBetweenPairsOfGalaxies(factor: Int): Long {
        expansionFactor = if (factor == 0) 0 else factor - 2
        expandUniverse()
        detectGalaxies()
        return sumOfDistancesBetweenGalaxies()
    }

    private fun expandUniverse() {
        expandRows()
        expandColumns()
    }

    private fun expandRows() {
        var index = 0
        while (index < universe.size) {
            if (rowIsEmpty(index)) {
                addEmptyRow(index)
                index++
            }
            index++
        }
    }

    private fun addEmptyRow(index: Int) = universe.add(index, MutableList(universe[0].size) { "*" }.toMutableList())
    private fun rowIsEmpty(index: Int) = universe[index].firstOrNull { it == "#" } == null
    private fun expandColumns() {
        var index = 0
        while (index < universe[0].size) {
            if (columnIsEmpty(index)) {
                addEmptyColumn(index)
                index++
            }
            index++
        }
    }

    private fun columnIsEmpty(index: Int) = universe.map { it[index] }.firstOrNull { it == "#" } == null
    private fun addEmptyColumn(index: Int) = universe.forEach { it.add(index, "*") }

    private fun detectGalaxies() {
        var rowExpansionFactor = 0
        universe.forEachIndexed { rowIndex, row ->
            if (isExpansionRow(rowIndex)) {
                rowExpansionFactor++
            }
            var columnExpansionFactor = 0
            row.forEachIndexed { columnIndex, space ->
                if (space == "#") {
                    galaxies.add(
                        Coordinate(
                            rowIndex + (rowExpansionFactor * expansionFactor).toLong(),
                            columnIndex + (columnExpansionFactor * expansionFactor).toLong()
                        )
                    )
                } else if (space == "*") {
                    columnExpansionFactor++
                }
            }
        }
    }

    private fun isExpansionRow(rowIndex: Int): Boolean {
        universe[rowIndex].forEach {
            if (it != "*") {
                return false
            }
        }
        return true
    }

    private fun sumOfDistancesBetweenGalaxies(): Long {
        var sum = 0.toLong()
        for (coordinate1 in 0 until galaxies.size - 1) {
            for (coordinate2 in coordinate1 + 1 until galaxies.size) {
                sum += galaxies[coordinate1].distanceToCoordinate(galaxies[coordinate2])
            }
        }
        return sum
    }


}

class SkyRecord(private val record: List<String>) {

    private val grid = mutableListOf<MutableList<String>>()
    fun getSky(): Sky {
        record.forEach { rowRecord ->
            val row = mutableListOf<String>()
            rowRecord.chunked(1).forEach { space ->
                row.add(space)
            }
            grid.add(row)
        }
        return Sky(grid)
    }
}