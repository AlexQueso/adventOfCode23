package day08

class Network(private val connections: List<Connection>) {

    fun getConnection(node: String): Connection {
        connections.forEach {
            if (it.node == node)
                return it
        }
        throw ConnectionNotFoundException("connection with node $node not found")
    }

    fun getStartingGhostConnections(): List<Connection> {
        val startingConnections = mutableListOf<Connection>()
        connections.forEach {
            if (it.node.endsWith("A")) {
                startingConnections.add(it)
            }
        }
        return startingConnections
    }
}