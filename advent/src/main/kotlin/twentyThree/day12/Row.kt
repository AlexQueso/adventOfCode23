package twentyThree.day12

class Row(private val springs: List<String>, private val damaged: List<Int>) {

    private var possibilities = calculatePossibilities()

    fun getPossibilities(): Int {
        return possibilities.size
    }

    private fun calculatePossibilities() : List<String> {
        val allCombinations = initiateAllCombinations()
        for (index in 1 until springs.size) {
            if (springs[index] != "?") {
                for (allCombinationsIndex in allCombinations.indices){
                    allCombinations[allCombinationsIndex] += springs[index]
                }
            } else {
                for (allCombinationsIndex in allCombinations.indices){
                    allCombinations.add(allCombinations[allCombinationsIndex] + ".")
                    allCombinations[allCombinationsIndex] += "#"
                }
            }
        }
        return allCombinations.filter { damaged == getCombinationDamage(it) }
    }

    private fun getCombinationDamage(combination: String): List<Int> {
        var damageCount = 0
        val combinationDamage = mutableListOf<Int>()
        combination.forEach {
            if (it == '.'){
                if (damageCount > 0) {
                    combinationDamage.add(damageCount)
                    damageCount = 0
                }
            } else {
                damageCount ++
            }
        }
        if (damageCount > 0) {
            combinationDamage.add(damageCount)
        }
        return combinationDamage
    }

    private fun initiateAllCombinations() : MutableList<String> {
        val allCombinations = mutableListOf<String>()
        if (springs[0] != "?") {
            allCombinations.add(springs[0])
        } else {
            allCombinations.add(".")
            allCombinations.add("#")
        }
        return allCombinations
    }
}
