package twentyThree.day08

class Instructions (private val instructions: List<String>) {

    private var index = 0

    fun getNext(): String{
        val nextInstruction = instructions[index]
        if (index < instructions.size-1) {
            index += 1
        } else {
            index = 0
        }
        return nextInstruction
    }

    fun reset() {
        index = 0
    }
}