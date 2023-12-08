package day06

class Race(private val time: Long, private val distance: Long) {

    var numberOfWinningPossibilities = 0
    fun numberOfWinningPossibilities(): Int {
        for(pressedTime in 1 until (time-1)){
            if (getDistanceSimulation(pressedTime, time) > distance){
                numberOfWinningPossibilities++
            }
        }
        return numberOfWinningPossibilities
    }

    private fun getDistanceSimulation(pressedTime: Long, time: Long) = (time - pressedTime) * pressedTime

}