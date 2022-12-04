package test.kotlin.generalutils


import main.kotlin.Day03rucksack
import main.kotlin.Day04CampCleanup
import org.junit.Assert
import org.junit.Test
import java.nio.file.Paths

class Day04CampCleanupTest {

    @Test
    fun testday3(){
        val projectDirAbsolutePath = Paths.get("").toAbsolutePath().toString()
        val inputPath = Paths.get(projectDirAbsolutePath, "/src/main/resources/input")

        val day4 = Day04CampCleanup("$inputPath/04_input_test.txt")
        Assert.assertTrue(day4.partOne() == 2)
        Assert.assertTrue(day4.partTwo() == 4)
    }

}