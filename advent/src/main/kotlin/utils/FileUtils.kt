package utils

import java.io.File

const val RESOURCES_FOLDER = "src/main/resources/"
const val INPUT_URL_BEGINNING = "src/main/resources/day"
const val INPUT_URL_END = "/input.txt"
const val EXAMPLE1_URL_END = "/example1.txt"
const val EXAMPLE2_URL_END = "/example2.txt"
fun printFileLineByLine(fileName: String) = File(fileName).forEachLine { println(it) }

fun getFileFromFileName(fileName: String) = File(fileName)

fun getInputFileFromDayNumber(dayNumber: Int) =
    getFileFromFileName(INPUT_URL_BEGINNING + dayNumber + INPUT_URL_END)

fun getExample1FileFromDayNumber(dayNumber: Int) =
    getFileFromFileName(INPUT_URL_BEGINNING + dayNumber + EXAMPLE1_URL_END)


fun getExample2FileFromDayNumber(dayNumber: Int) =
    getFileFromFileName(INPUT_URL_BEGINNING + dayNumber + EXAMPLE2_URL_END)
