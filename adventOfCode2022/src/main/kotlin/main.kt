package main.kotlin

import main.kotlin.day01calories.CalorieCounter
import org.junit.Assert
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
    }catch(e:Exception){
        e.printStackTrace()
    }
}