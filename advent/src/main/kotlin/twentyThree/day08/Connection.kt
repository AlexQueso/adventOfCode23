package twentyThree.day08

class Connection (val node: String, private val left: String, private val right: String){

    fun getLeftOrRight(instruction: String): String{
        if (instruction == "L") {
            return left
        }
        return right
    }

    override fun toString(): String {
        return node
    }


}