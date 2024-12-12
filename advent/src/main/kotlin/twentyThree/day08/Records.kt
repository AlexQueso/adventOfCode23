package twentyThree.day08

class NavigationRecord(private val record: List<String>) {

    fun getNavigation(): Navigation {
        return Navigation(getInstructions(), getNetwork())
    }

    private fun getInstructions(): Instructions {
        return InstructionsRecord(record[0]).getInstructions()
    }

    private fun getNetwork(): Network {
        return NetworkRecord(record.subList(2, record.size)).getNetwork()
    }
}

class InstructionsRecord(private val record: String) {
    fun getInstructions(): Instructions {
        return Instructions(record.chunked(1))
    }
}

class NetworkRecord(private val record: List<String>) {
    private val connections = mutableListOf<Connection>()
    fun getNetwork(): Network {
        record.forEach {
            connections.add(ConnectionRecord(it).getConnection())
        }
        return Network(connections)
    }
}

class ConnectionRecord(private val record: String) {
    fun getConnection(): Connection {
        val node = record.substring(0, 3)
        val left = record.substring(7, 10)
        val right = record.substring(12, 15)
        return Connection(node, left, right)
    }

}