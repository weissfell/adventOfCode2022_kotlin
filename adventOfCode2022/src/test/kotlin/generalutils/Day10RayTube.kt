package test.kotlin.generalutils


import main.kotlin.day06tuning.Day07DeviceSpace
import main.kotlin.day08treetophouse.Day08TreetopHouse
import main.kotlin.day10raytube.Day10RayTube
import org.junit.Assert
import org.junit.Test
import java.nio.file.Paths

class Day10RayTube {


    @Test
    fun testDay() {
        val projectDirAbsolutePath = Paths.get("").toAbsolutePath().toString()
        val inputPath = Paths.get(projectDirAbsolutePath, "/src/main/resources/input")

        val day = Day10RayTube("$inputPath/10_input_test.txt")
        Assert.assertTrue(day.partOne() == 13140)
        day.partTwo()
        Assert.assertTrue(true)

    }

}