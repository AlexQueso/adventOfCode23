package day02

import kotlin.reflect.KMutableProperty1

const val MAX_RED = 12
const val MAX_BLUE = 14
const val MAX_GREEN = 13

class Game(
    var id: Int,
    private val subsets: MutableList<Subset> = mutableListOf(),
) {
    fun isPossible(): Boolean {
        subsets.forEach {
            if (it.isImpossible()) {
                return false
            }
        }
        return true
    }

    fun power(): Int {
        return minimumNumberCubesByColour(Subset::red) * minimumNumberCubesByColour(Subset::blue) * minimumNumberCubesByColour(
            Subset::green
        )
    }

    private fun minimumNumberCubesByColour(colourGetter: KMutableProperty1<Subset, Int>): Int {
        var minimumCubes = 0
        subsets.forEach {
            val numberOfCubes = colourGetter.invoke(it)
            if (numberOfCubes > minimumCubes) {
                minimumCubes = numberOfCubes
            }
        }
        return minimumCubes
    }
}

class Subset {
    var red: Int = 0
    var blue: Int = 0
    var green: Int = 0

    fun isImpossible() = red > MAX_RED || blue > MAX_BLUE || green > MAX_GREEN

}
