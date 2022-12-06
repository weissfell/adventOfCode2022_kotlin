package test.kotlin.generalutils


import main.kotlin.day03rucksack.Day03rucksack
import org.junit.Assert
import org.junit.Test
import java.nio.file.Paths

class Day03RucksackTest {

    @Test
    fun testday3(){
        val projectDirAbsolutePath = Paths.get("").toAbsolutePath().toString()
        val inputPath = Paths.get(projectDirAbsolutePath, "/src/main/resources/input")

        val day3 = Day03rucksack("$inputPath/03_input_test.txt")
        Assert.assertTrue(day3.partOne() == 157)

        Assert.assertTrue(day3.partTwo() == 70)
    }

}