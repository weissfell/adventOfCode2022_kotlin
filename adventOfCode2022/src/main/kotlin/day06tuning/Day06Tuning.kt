package main.kotlin.day06tuning

import main.kotlin.generalutils.ChristmasFileReader

class Day06Tuning(val src: String) {
    val strLines = ChristmasFileReader(src).fetchLinesAsString()

    fun partOne() : Int{
        var result = 4
        val charArr = strLines[0].toString().toCharArray()
        val currStr = arrayOf(charArr[0],charArr[1],charArr[2],charArr[3])
        for (i in 4 until charArr.size) {
            if(!(currStr[0] == currStr[1] || currStr[0] == currStr[2] || currStr[0] == currStr[3] ||
                currStr[1] == currStr[2] || currStr[1] == currStr[3] || currStr[2] == currStr[3]))
                return result
            currStr[0] = currStr[1]
            currStr[1] = currStr[2]
            currStr[2] = currStr[3]
            currStr[3] = charArr[i]
            result++
        }
        return result
    }

    fun partTwo() : Int{
        var result = 14
        val charArr = strLines[0].toString().toCharArray()
        val currArr = CharArray(14)
        for (i in 0..13){
            currArr[i] = charArr[i]
        }

        for (i in 14 until charArr.size) {
            var found = false
            var innerCount = 0
            while(innerCount < 13){
                val currChar = currArr[innerCount]
                for (i in innerCount..13){
                    if(i == innerCount) continue
                    if(currChar == currArr[i]) {
                        found = true
                    }
                }
                innerCount++
            }
            if(!found) return result
            for (i in 0..12){
                currArr[i] = currArr[i+1]
            }
            currArr[13] = charArr[i]
            result++
        }
        return result
    }

}