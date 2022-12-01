package main.kotlin.generalutils

import java.io.BufferedReader

class FileReader {

    val resultList = mutableListOf<String>()

    fun fetchLinesAsString(fileStream: BufferedReader): MutableList<String> {
        fileStream.lines().forEach {
            resultList.add(it.toString())
        }
        return resultList
    }

}