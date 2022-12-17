package test.kotlin.generalutils


import main.kotlin.Day11Dijkstra
import org.junit.Assert
import org.junit.Test
import java.nio.file.Paths

class Day11DijkstraTest {


    @Test
    fun testDay() {
        val projectDirAbsolutePath = Paths.get("").toAbsolutePath().toString()
        val inputPath = Paths.get(projectDirAbsolutePath, "/src/main/resources/input")

        val day = Day11Dijkstra("$inputPath/11_input_test.txt")
        Assert.assertTrue(day.partOne() == 31)
        Assert.assertTrue(day.partTwo() == 29)

    }

}