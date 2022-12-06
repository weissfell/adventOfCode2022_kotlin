package main.kotlin.day04campcleanup

import main.kotlin.generalutils.ChristmasFileReader

class Day04CampCleanup(val src: String) {
    val strLines = ChristmasFileReader(src).fetchLinesAsString()

    fun partOne() : Int {
        var result = 0
        strLines.forEach {
            val elfSections = it.split(',')
            val elf0Responsiblities = elfSections[0].split('-')
            val elf1Responsiblities = elfSections[1].split('-')
            if((elf0Responsiblities[0].toInt() <= elf1Responsiblities[0].toInt() &&
                    elf0Responsiblities[1].toInt() >= elf1Responsiblities[1].toInt()) ||
                (elf0Responsiblities[0].toInt() >= elf1Responsiblities[0].toInt() &&
                    elf0Responsiblities[1].toInt() <= elf1Responsiblities[1].toInt()))
                result++
        }
        return result
    }

    fun partTwo() : Int {
        var result = 0
        strLines.forEach {
            val elfSections = it.split(',')
            val elf0Responsiblities = elfSections[0].split('-')
            val elf1Responsiblities = elfSections[1].split('-')
            if(elf0Responsiblities[0].toInt() <= elf1Responsiblities[0].toInt() &&
                elf0Responsiblities[1].toInt() >= elf1Responsiblities[0].toInt()) {
                result++
            } else if (elf0Responsiblities[0].toInt() <= elf1Responsiblities[1].toInt() &&
                elf0Responsiblities[1].toInt() >= elf1Responsiblities[1].toInt()){
                result++
            }else if (elf0Responsiblities[0].toInt() >= elf1Responsiblities[0].toInt() &&
                elf0Responsiblities[0].toInt() <= elf1Responsiblities[1].toInt()){
                result++
            }else if (elf0Responsiblities[0].toInt() <= elf1Responsiblities[0].toInt() &&
                elf0Responsiblities[1].toInt() >= elf1Responsiblities[1].toInt()){
                result++
            }
        }
        return result
    }
}