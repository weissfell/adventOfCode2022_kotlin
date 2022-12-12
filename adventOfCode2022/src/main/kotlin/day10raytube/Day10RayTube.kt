package main.kotlin.day10raytube

import main.kotlin.generalutils.ChristmasFileReader

class Day10RayTube (val src: String) {
    val strLines = ChristmasFileReader(src).fetchLinesAsString()
    val cpu = CPU(1)
    init{
        strLines.forEach {
            if(it.contains("noop")){
                cpu.noop()
            }
            else if (it.contains("addx")){
                var strArr = it.split(' ')
                cpu.addX(strArr[1].toInt())
            }
        }
    }

    fun partOne() : Int{
        val numToCheck = arrayOf(20,60,100,140,180,220)
        var result = 0
        numToCheck.forEach {
            result += (cpu.getCycleX(it-1)*it)
        }
        return result
    }

    fun partTwo(){
        var strOutput = ""
        for(i in 0..240){
            if(i%40==0)strOutput="$strOutput\n"
            strOutput = "$strOutput${doCycle(i%40, i)}"
        }
        println(strOutput)

    }

    private fun doCycle(xPosition : Int, currCycle : Int) : Char{
        //draw at pixel x
        if(cpu.getCycleX(currCycle) == xPosition || cpu.getCycleX(currCycle) == xPosition-1 || cpu.getCycleX(currCycle) == xPosition+1)
            return '#'
        //finish calculation of current cycle
        return '.'
    }
}

class CPU(private var x : Int, private var cycle : Int = 0){

    private val cycleMap = hashMapOf<Int, Int>()

    init {
        cycleMap[0] = x
    }

    fun noop(){
        cycle += 1
        cycleMap[cycle] = cycleMap.getValue(cycle -1)
    }

    fun addX(addX : Int){
        cycle += 1
        cycleMap[cycle] = cycleMap.getValue(cycle -1)
        cycle += 1
        cycleMap[cycle] = cycleMap.getValue(cycle -1) + addX

    }

    fun getCycleX(cycleNo: Int): Int {
        return cycleMap[cycleNo] ?: return 0
    }

}