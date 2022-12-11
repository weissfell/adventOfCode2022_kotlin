package test.kotlin.generalutils


import main.kotlin.day06tuning.Day07DeviceSpace
import org.junit.Assert
import org.junit.Test
import java.nio.file.Paths

class Day07DeviceSpaceTest {


    @Test
    fun testday7() {
        val projectDirAbsolutePath = Paths.get("").toAbsolutePath().toString()
        val inputPath = Paths.get(projectDirAbsolutePath, "/src/main/resources/input")

        val day7 = Day07DeviceSpace("$inputPath/07_input_test.txt")
        Assert.assertTrue(day7.partOne() == 95437)
        val day7_2 = Day07DeviceSpace("$inputPath/07_input_test.txt")
        Assert.assertTrue(day7_2.partTwo() == 24933642)

    }

}