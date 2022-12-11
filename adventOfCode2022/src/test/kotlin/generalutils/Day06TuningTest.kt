package test.kotlin.generalutils


import main.kotlin.day06tuning.Day06Tuning
import main.kotlin.day06tuning.Day07DeviceSpace
import org.junit.Assert
import org.junit.Test
import java.nio.file.Paths

class Day06TuningTest {


    @Test
    fun testday6() {
        val projectDirAbsolutePath = Paths.get("").toAbsolutePath().toString()
        val inputPath = Paths.get(projectDirAbsolutePath, "/src/main/resources/input")

        val day6 = Day06Tuning("$inputPath/06_input_test.txt")
        Assert.assertTrue(day6.partOne() == 7)
        println(day6.partTwo())
        Assert.assertTrue(day6.partTwo() == 19)
    }

}