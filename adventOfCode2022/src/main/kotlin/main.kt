package main.kotlin

import main.kotlin.day01calories.CalorieCounter
import main.kotlin.day03rucksack.Day03rucksack
import main.kotlin.day04campcleanup.Day04CampCleanup
import main.kotlin.day05supplystacks.Day05Stacker
import main.kotlin.day06tuning.Day06Tuning
import main.kotlin.day06tuning.Day07DeviceSpace
import main.kotlin.day08treetophouse.Day08TreetopHouse
import main.kotlin.day10raytube.Day10RayTube
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
        val day6 = Day06Tuning("$inputPath/06_input.txt")
        println("Day 6 Pt I: ${day6.partOne()}")
        println("Day 6 Pt II: ${day6.partTwo()}")
        val day7 = Day07DeviceSpace("$inputPath/07_input.txt")
        println("Day 7 Pt I: ${day7.partOne()}")
        val day7_2 = Day07DeviceSpace("$inputPath/07_input.txt")
        println("Day 7 Pt II: ${day7_2.partTwo()}")
//        val day8 = Day08TreetopHouse("$inputPath/08_input.txt")
//        println("Day 8 Pt I: ${day8.partOne()}")
        val day10 = Day10RayTube("$inputPath/10_input.txt")
        println("Day 10 Pt I: ${day10.partOne()}")
        println("Day 10 Pt II...\n")
        day10.partTwo()
    }catch(e:Exception){
        e.printStackTrace()
    }
}