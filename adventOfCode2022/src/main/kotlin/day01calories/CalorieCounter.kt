package main.kotlin.day01calories

import main.kotlin.generalutils.ChristmasFileReader
import java.util.logging.LogManager
import java.util.logging.Logger

class CalorieCounter(val src : String) {

    val strLines = ChristmasFileReader(src).fetchLinesAsString()
    var currMaxFood : Int = 0
    val toughestElfs = mutableListOf<Int>()

    fun calcDay1(){
        var val2Check = 0
        strLines.forEach {
            if (it.length == 0) {
                setMaxFoodCarried(val2Check)
                toughestElfs.add(val2Check)
                val2Check = 0
            }
            else {
                val2Check += it.toInt()
            }
        }
        println("Result Day 1 Part 1 : $currMaxFood")
        toughestElfs.sort()

        println("Result Day 1 Part 2 : Toughes Elves are carrying... ${toughestElfs[toughestElfs.size - 1]} - ${toughestElfs[toughestElfs.size - 2]} - ${toughestElfs[toughestElfs.size - 3]} - so result ist: " +
                "${toughestElfs[toughestElfs.size - 1] + toughestElfs[toughestElfs.size - 2] + toughestElfs[toughestElfs.size - 3]}")
    }


    private fun setMaxFoodCarried(val2Check : Int){
        if (val2Check > currMaxFood)
            currMaxFood = val2Check
    }

}