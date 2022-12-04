package main.kotlin

import main.kotlin.generalutils.ChristmasFileReader
import java.lang.Exception

class Day03rucksack(val src: String) {
    val strLines = ChristmasFileReader(src).fetchLinesAsString()

    fun partOne(): Int {
        var result = 0
        strLines.forEach { line ->
            val parts = mutableListOf<String>()
            var currStr = StringBuilder()
            for((index, char) in line.toCharArray().withIndex()){
                if(index == (line.length / 2)) {
                    parts.add(currStr.toString())
                    currStr = StringBuilder()
                }
                currStr.append(char)
            }
            parts.add(currStr.toString())
            result += getDuplicatedCharValue(parts)
        }
        return result
    }

    fun partTwo() : Int {
        var result = 0
        var index = 0
        while(index < strLines.size-1){
            result+=getCharValue(searchChar(index))
            index += 3
        }
        return result

    }

    private fun searchChar(index : Int) : Char? {
        var result : Char
        strLines.get(index).forEach { lookupChar ->
            while(true){
                if(strLines[index + 1].contains(lookupChar)){
                    result = lookupChar
                    while(true){
                        if(strLines[index + 2].contains(lookupChar)){
                            return lookupChar
                        } else {
                            break
                        }
                    }
                    break
                }
                break
            }
        }
        return null
    }

    private fun getDuplicatedCharValue(parts: List<String>): Int {
        parts[0].forEach { currChar ->
            if (parts[1].contains(currChar)) {
                return getCharValue(currChar)
            }

        }
        return 0
    }

    private fun getCharValue(char : Char?) : Int {
        if(char == null)
            throw Exception("OH NOOOO")
        if (char.code in 65..90) {
            return char.code - 38
        } else if (char.code in 97..122) {
            return char.code - 96
        }
        return 0
    }
}