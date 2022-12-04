package test.kotlin.generalutils


import main.kotlin.generalutils.ChristmasFileReader
import org.junit.Assert
import org.junit.Test

class FileReaderTest {

    val testString = "/main/resources/input/01_input"

    @Test
    fun readFromFile() {
        Assert.assertTrue(ChristmasFileReader(testString).fetchLinesAsString().size > 0)
    }

}