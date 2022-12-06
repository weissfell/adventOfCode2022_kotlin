package main.kotlin.day05supplystacks

import main.kotlin.generalutils.ChristmasFileReader

class Day05Stacker (val src: String) {
    val strLines = ChristmasFileReader(src).fetchLinesAsString()
    val commandList : MutableList<String>
    var supplyStack = SupplyStack(0)

    init{
        val stackRows = mutableListOf<CharArray>()

        run list@ {
            strLines.forEach { it ->
                if(it.toCharArray().contains('1')) {
                    var maxChar = '1'
                    it.toCharArray().forEach { currChar ->
                        if (currChar.code > maxChar.code)
                            maxChar = currChar
                    }
                    supplyStack = SupplyStack(48 + maxChar.code)
                    return@list
                }
                stackRows.add(it.toCharArray())
            }
        }

        val size = stackRows[0].size
        var count = 0;
        for(i in 1..size step 4){
            val supplyStackCurr = mutableListOf<SupplyCrate>()
            stackRows.reversed().forEach { charArr ->
                val currChar = charArr[i]
                if (currChar.code in 65..90) {
                    supplyStackCurr.add(SupplyCrate(currChar))
                }
            }
            supplyStack.setupStack(count, supplyStackCurr)
            count++
        }

        commandList = mutableListOf()
        strLines.forEach {
            if(it.contains("move"))
                commandList.add(it)
        }

    }


    fun partOne() : String{
        var result = ""
        commandList.forEach { command ->
            var commandSplit = command.split(' ')
            for(i in 1..commandSplit[1].toInt()){
                supplyStack.moveSingleCrate(commandSplit[3].toInt() - 1,commandSplit[5].toInt() - 1)

            }
        }
        for (i in 0..supplyStack.getSize() - 1)
            result += supplyStack.getTopCrate(i)
        return result
    }

    fun partTwo() : String {
        var result = ""
        commandList.forEach { command ->
            var commandSplit = command.split(' ')
                supplyStack.moveAllCrates(commandSplit[3].toInt() - 1,commandSplit[5].toInt() - 1, commandSplit[1].toInt())
        }
        for (i in 0..supplyStack.getSize() - 1)
            result += supplyStack.getTopCrate(i)
        return result
    }

}