package test.kotlin.generalutils


import main.kotlin.day05supplystacks.Day05Stacker
import org.junit.Assert
import org.junit.Test
import java.nio.file.Paths

class Day05StackerTest {


    @Test
    fun testday5() {
        val projectDirAbsolutePath = Paths.get("").toAbsolutePath().toString()
        val inputPath = Paths.get(projectDirAbsolutePath, "/src/main/resources/input")

        val day5 = Day05Stacker("$inputPath/05_input_test.txt")
        Assert.assertTrue(day5.partOne() == "CMZ")
        val day5_2 = Day05Stacker("$inputPath/05_input_test.txt")
        Assert.assertTrue(day5_2.partTwo() == "MCD")
    }

}