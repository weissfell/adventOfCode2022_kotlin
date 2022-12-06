package main.kotlin

import main.kotlin.day01calories.CalorieCounter
import main.kotlin.day03rucksack.Day03rucksack
import main.kotlin.day04campcleanup.Day04CampCleanup
import main.kotlin.day05supplystacks.Day05Stacker
import java.lang.Exception
import java.nio.file.Paths

fun main() {
    try{
        val projectDirAbsolutePath = Paths.get("").toAbsolutePath().toString()
        val inputPath = Paths.get(projectDirAbsolutePath, "/src/main/resources/input")

        val calCounter = CalorieCounter("$inputPath/01_input.txt")
        calCounter.calcDay1()
        val tictactoe = Day02tictactoe("$inputPath/02_input.txt")
        tictactoe.calcDay2()
        val day3 = Day03rucksack("$inputPath/03_input.txt")
        println("Day 3 Pt I: ${day3.partOne()}")
        println("Day 3 Pt II: ${day3.partTwo()}")
        val day4 = Day04CampCleanup("$inputPath/04_input.txt")
        println("Day 4 Pt I: ${day4.partOne()}")
        println("Day 4 Pt II: ${day4.partTwo()}")
        val day5 = Day05Stacker("$inputPath/05_input.txt")
        println("Day 5 Pt I: ${day5.partOne()}")
        val day5_2 = Day05Stacker("$inputPath/05_input.txt")
        println("Day 5 Pt II: ${day5_2.partTwo()}")
    }catch(e:Exception){
        e.printStackTrace()
    }
}