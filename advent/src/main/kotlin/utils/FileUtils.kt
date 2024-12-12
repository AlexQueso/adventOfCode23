package utils

import java.io.File

const val INPUT_URL_BEGINNING = "advent/src/main/resources/"
const val INPUT_URL_END = "/input.txt"
const val EXAMPLE1_URL_END = "/example1.txt"
const val EXAMPLE2_URL_END = "/example2.txt"

fun printFileLineByLine(fileName: String) = File(fileName).forEachLine { println(it) }

fun getFileFromFileName(fileName: String) = File(fileName)

fun getInputFileFromDayNumber(day: String, year: String) =
    getFileFromFileName("$INPUT_URL_BEGINNING$year/$day$INPUT_URL_END")

fun getExample1FileFromDayNumber(day: String, year: String) =
    getFileFromFileName("$INPUT_URL_BEGINNING$year/$day$EXAMPLE1_URL_END")

fun getExample2FileFromDayNumber(day: String, year: String) =
    getFileFromFileName("$INPUT_URL_BEGINNING$year/$day$EXAMPLE2_URL_END")
