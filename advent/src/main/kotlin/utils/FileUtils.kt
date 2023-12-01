package utils

import java.io.File

const val RESOURCES_FOLDER = "src/main/resources/"
fun printFileLineByLine(fileName: String) = File(fileName).forEachLine { println(it) }

fun getFileFromFileName(fileName: String) = File(fileName)