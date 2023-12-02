package day2

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

    fun power() = minimumColourCubes(Subset::red) * minimumColourCubes(Subset::red) * minimumColourCubes(Subset::red)

    private fun minimumColourCubes(getter: KMutableProperty1<Subset, Int>): Int {
        var minimumRedCubes = 0
        subsets.forEach {
            if (getter.invoke(it) > minimumRedCubes){
                minimumRedCubes = getter.invoke(it)
            }
        }
        return minimumRedCubes
    }
}

class Subset {
    var red: Int = 0
    var blue: Int = 0
    var green: Int = 0

    fun isImpossible(): Boolean {
        return red > MAX_RED || blue > MAX_BLUE || green > MAX_GREEN
    }

}
