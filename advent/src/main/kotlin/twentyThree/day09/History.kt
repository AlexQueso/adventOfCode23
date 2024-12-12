package twentyThree.day09

class History(private val elements: MutableList<Int>) {

    fun allElementsAreZero(): Boolean {
        elements.forEach {
            if (0 != it) {
                return false
            }
        }
        return true
    }

    fun getNextLevelHistory(): History{
        val newElements = mutableListOf<Int>()
        for (index in 0 until elements.size-1) {
            newElements.add(elements[index+1] - elements[index])
        }
        return History(newElements)
    }

    fun getLast(): Int {
        return elements.last()
    }

    fun getFirst(): Int {
        return elements.first()
    }

    fun addElementToTheEnd(element: Int) {
        elements.add(element)
    }

    fun addElementToTheBeginning(element: Int) {
        elements.add(0, element)
    }
}
