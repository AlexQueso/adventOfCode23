package day08

class Navigation (private val instructions: Instructions, private val network: Network) {

    fun stepsToZZZ(): Long{
        var currentConnection = network.getConnection("AAA")
        var steps : Long = 0
        while (currentConnection.node != "ZZZ") {
            val nextNode = currentConnection.getLeftOrRight(instructions.getNext())
            currentConnection = network.getConnection(nextNode)
            steps ++
        }
        return steps
    }

    fun ghostStepsToXXZ(): Long {
        var steps : Long = 1
        network.getStartingGhostConnections().forEach {
            steps = findLCM(steps, ghostSteps(it))
            instructions.reset()
        }
        return steps
    }

    private fun ghostSteps(startingConnection: Connection): Long {
        var currentConnection = startingConnection
        var steps : Long = 0
        while (!currentConnection.node.endsWith("Z")) {
            val nextNode = currentConnection.getLeftOrRight(instructions.getNext())
            currentConnection = network.getConnection(nextNode)
            steps ++
        }
        return steps
    }

    private fun findLCM(a: Long, b: Long): Long {
        val larger = if (a > b) a else b
        val maxLcm : Long = a * b
        var lcm = larger
        while (lcm <= maxLcm) {
            if (lcm % a == 0.toLong() && lcm % b == 0.toLong()) {
                return lcm
            }
            lcm += larger
        }
        return maxLcm
    }
}