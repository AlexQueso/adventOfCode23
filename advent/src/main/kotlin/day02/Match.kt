package day02

class Match(
    private val games: MutableList<Game> = mutableListOf(),
) {

    fun addGame(game: Game) {
        games.add(game)
    }

    fun sumOfPossibleGamesIds(): Int {
        var sum = 0
        games.forEach {
            if (it.isPossible()) {
                sum += it.id
            }
        }
        return sum
    }

    fun sumOfGamePowers(): Int {
        var sum = 0
        games.forEach {
            sum += it.power()
        }
        return sum
    }
}