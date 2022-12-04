package main.kotlin

import main.kotlin.generalutils.ChristmasFileReader

class Day03rucksack(val src: String) {
    val strLines = ChristmasFileReader(src).fetchLinesAsString()

    fun partOne(): Int {
        var result = 0
        strLines.forEach { line ->
            val newLine = line.toCharArray().also { it[line.length/2 - 1] = '.' }.joinToString("")
            val parts = newLine.split('.')
            result += getDuplicatedCharValue(parts)
        }
        return result
    }

    fun getDuplicatedCharValue(parts: List<String>): Int {
        parts[0].forEach { currChar ->
            if (parts[1].contains(currChar)) {
                if (currChar.code in 65..90) {
                    return currChar.code - 38
                } else if (currChar.code in 97..122) {
                    return currChar.code - 96
                }
                println("This shouldnt'happen!" + currChar)
            }

        }
        println("This shouldnt'happen!" + parts)
        return 0
    }
}