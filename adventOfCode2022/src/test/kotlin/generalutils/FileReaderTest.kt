package test.kotlin.generalutils

import org.junit.Test
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL
import java.net.URLConnection

class FileReaderTest {

    val testString = "https://adventofcode.com/2022/day/1/input"

    @Test
    fun connectToUrlTest(){
        val url = URL(testString)
        val inputStream : BufferedReader = BufferedReader(InputStreamReader(url.openStream()))
        inputStream.lines().forEach {
            println(it.toString())
        }
    }

}