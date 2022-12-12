package main.kotlin.day08treetophouse

import main.kotlin.generalutils.ChristmasFileReader

class Day08TreetopHouse(val src: String) {
    val strLines = ChristmasFileReader(src).fetchLinesAsString()

    val mapMatrix = mutableListOf<MutableList<Int>>()

    init{
        strLines.forEach {
            val lineArray = mutableListOf<Int>()
            it.forEach { charNum ->
                lineArray.add(charNum.digitToInt())
            }
            mapMatrix.add(lineArray)
        }
    }

    var row = 0
    var col = 0
    fun partOne() : Int{
        var result = 0
        row = 0
        mapMatrix.forEach { treeRow ->
            col = 0
            treeRow.forEach {
                if(col == 0 || col == treeRow.size - 1 || row == 0 || row == mapMatrix.size-1) {
                    result++
                }else if (visibleFromRight() || visibleFromLeft() || visibleFromTop() || visibleFromBottom()){
                    result ++
                    println("Hidden: $row , $col")
                }
                 col++
            }
            row++
        }
        return result
    }

    private fun visibleFromRight() : Boolean{
        val currRow = mapMatrix[row]
        val currVal = mapMatrix[row][col]
        for(i in col + 1 until currRow.size){
            if(currVal <= mapMatrix[row][i]) return false
        }
        return true
    }
    private fun visibleFromLeft() : Boolean{
        val currVal = mapMatrix[row][col]
        for(i in (col - 1) downTo 0){
            if(currVal <= mapMatrix[row][i]) return false
        }
        return true
    }
    private fun visibleFromTop() : Boolean{
        val currVal = mapMatrix[row][col]
        for(i in row until mapMatrix.size){
            if(currVal <= mapMatrix[i][col]) return false
        }
        return true
    }
    private fun visibleFromBottom() : Boolean{
        val currVal = mapMatrix[row][col]
        for(i in (row-1) downTo 0){
            if(currVal <= mapMatrix[i][col]) return false
        }
        return true
    }

}