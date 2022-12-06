package main.kotlin.day05supplystacks

class SupplyStack (private val rowNum : Int){
    val stackList = mutableListOf<MutableList<SupplyCrate>>()

    fun setupStack(index : Int, crateList : MutableList<SupplyCrate>){
        stackList.add(index, crateList)
    }

    fun moveSingleCrate(sourceIndex : Int, targetIndex : Int){
        val crateListSrc = stackList.get(sourceIndex )
        val crateLstTarget = stackList.get(targetIndex)
        crateLstTarget.add(crateListSrc.get(crateListSrc.size - 1))
        crateListSrc.removeLast()
    }

    fun moveAllCrates(sourceIndex : Int, targetIndex : Int, numCrates : Int){
        val crateListSrc = stackList.get(sourceIndex )
        val crateLstTarget = stackList.get(targetIndex)

        for (i in numCrates downTo 1){
            crateLstTarget.add(crateListSrc.get(crateListSrc.size - i))
            crateListSrc.removeAt(crateListSrc.size - i)
        }

    }

    fun getSize() : Int {
        return stackList.size
    }

    fun getTopCrate(index : Int) : Char {
        return stackList.get(index).get(stackList.get(index).lastIndex).name
    }
}

class SupplyCrate (val name : Char)