package twentyThree.day12

import utils.getExample1FileFromDayNumber
import utils.getInputFileFromDayNumber
import java.io.File

const val DAY = "12"

fun main(){
    println("1example: " + sumOfPossibleArrangements(getExample1FileFromDayNumber(DAY, "2023")))
    println("1: " + sumOfPossibleArrangements(getInputFileFromDayNumber(DAY, "2023")))
}

fun sumOfPossibleArrangements(input: File): Int {
    return FieldRecord(input.readLines()).getField().sumOfPossibleArrangements()
}

class FieldRecord(private val record: List<String>) {
    fun getField() = Field(record.map { RowRecord(it).getRow() })
}

class RowRecord(private val record: String) {
    fun getRow() = Row(getSprings(), getDamaged())
    private fun getSprings() = record.split(" ")[0].chunked(1)
    private fun getDamaged() = record.split(" ")[1].split(",").map { it.toInt() }
}
