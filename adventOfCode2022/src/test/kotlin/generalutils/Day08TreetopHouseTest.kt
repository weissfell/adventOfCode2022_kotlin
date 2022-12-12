package test.kotlin.generalutils


import main.kotlin.day06tuning.Day07DeviceSpace
import main.kotlin.day08treetophouse.Day08TreetopHouse
import org.junit.Assert
import org.junit.Test
import java.nio.file.Paths

class Day08TreetopHouseTest {


    @Test
    fun testday7() {
        val projectDirAbsolutePath = Paths.get("").toAbsolutePath().toString()
        val inputPath = Paths.get(projectDirAbsolutePath, "/src/main/resources/input")

        val day8 = Day08TreetopHouse("$inputPath/08_input_test.txt")
        Assert.assertTrue(day8.partOne() == 21)

    }

}