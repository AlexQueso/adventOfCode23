package day09

class Sequence(private val histories: MutableList<History>) {
    fun calculateExtraLastValue() {
        addNextLevelHistories()
        addExtraZero()
        addExtraLastValues()
    }

    fun calculateExtraPreviousValue() {
        addNextLevelHistories()
        addExtraZero()
        addExtraPreviousValues()
    }

    fun getExtraLastValue() = histories[0].getLast()

    fun getExtraPreviousValue() = histories[0].getFirst()
    private fun addExtraLastValues() {
        for (index in (0 until histories.size-1).reversed()) {
            val newElement = histories[index+1].getLast() + histories[index].getLast()
            histories[index].addElementToTheEnd(newElement)
        }
    }

    private fun addExtraPreviousValues() {
        for (index in (0 until histories.size-1).reversed()) {
            val newElement = histories[index].getFirst() - histories[index+1].getFirst()
            histories[index].addElementToTheBeginning(newElement)
        }
    }

    private fun addExtraZero() {
        histories[histories.size - 1].addElementToTheEnd(0)
    }

    private fun addNextLevelHistories(){
        var index = 0
        while (!histories[index].allElementsAreZero()){
            histories.add(histories[index].getNextLevelHistory())
            index ++
        }
    }
}

class SequenceRecord(private val record: String) {
    fun getSequence(): Sequence {
        val history = record
            .split(" ")
            .map { it.toInt() }
            .toMutableList()
        return Sequence(mutableListOf(History(history)))
    }
}
