package main.kotlin

import main.kotlin.day01calories.CalorieCounter
import java.lang.Exception
import java.nio.file.Paths

fun main() {
    try{
        val projectDirAbsolutePath = Paths.get("").toAbsolutePath().toString()
        val inputPath = Paths.get(projectDirAbsolutePath, "/src/main/resources/input")

        val calCounter = CalorieCounter("$inputPath/01_input.txt")
        calCounter.calcDay1()
    }catch(e:Exception){
        e.printStackTrace()
    }
}