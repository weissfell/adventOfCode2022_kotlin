package main.kotlin.generalutils

import java.io.BufferedReader
import java.io.File

class ChristmasFileReader (sourceFile : String) {

    val bufferedReader : BufferedReader = File(sourceFile).bufferedReader()

    fun fetchLinesAsString(): MutableList<String> {
        return bufferedReader.readLines().toMutableList()
    }

}