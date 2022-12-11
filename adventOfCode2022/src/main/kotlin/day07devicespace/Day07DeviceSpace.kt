package main.kotlin.day06tuning

import main.kotlin.generalutils.ChristmasFileReader

class Day07DeviceSpace(val src: String) {
    val strLines = ChristmasFileReader(src).fetchLinesAsString()
    val lstDirectories = mutableListOf<Directory>()

    init{
        var currDirectory : Directory = MainDirectory("/", mutableListOf(), mutableListOf())
        lstDirectories.add(currDirectory)
        strLines.forEach { currLine ->

            if(currLine.startsWith("$ cd")){
                if(currLine.startsWith("$ cd /"))
                    return@forEach
                else if(currLine.startsWith("$ cd ..") && currDirectory is SubDirectory){
                    currDirectory = (currDirectory as SubDirectory).parent
                } else {
                    try{
                        currDirectory = currDirectory.lstChildrenDirectories.first {
                                currLine.removePrefix("$ cd ").contains(it.name)
                        }
                    }catch (e:Exception){
                        println("y")
                    }
                }
            }

            else if(currLine.startsWith("dir")){
                val newDir = SubDirectory(currLine.removePrefix("dir "), currDirectory, mutableListOf(), mutableListOf() )
                lstDirectories.add(newDir)
                currDirectory.lstChildrenDirectories.add(newDir)
            }
            else if(currLine.startsWith("$")){

            }
            else {
                val sizeAndName = currLine.split(" ")
                currDirectory.lstChildrenFiles.add(File(sizeAndName[1], sizeAndName[0].toInt()))
            }

        }
    }

    fun partOne() : Int{
        getDirectoryFileSizeWithChildren(lstDirectories[0])
        var result = 0
        lstDirectories.forEach { dir ->
            if(dir.size <= 100000)
                result+=dir.size
        }
        return result

    }

    var checkNum = 30000000
    fun partTwo() : Int {

        getDirectoryFileSizeWithChildren(lstDirectories[0])
        val free = 70000000 - lstDirectories[0].size
        checkNum = 30000000 - free
        var result = 0
        lstDirectories.forEach { dir ->
            if(dir.size >= checkNum && !firstCloserTo30MioThanSecond(result, dir.size))
                result=dir.size
        }
        return result
    }

    private fun firstCloserTo30MioThanSecond(numA : Int, numB : Int) : Boolean{
        val diffA =
            if(numA > checkNum) numA - checkNum
            else checkNum - numA
        val diffB =
            if(numB > checkNum) numB - checkNum
            else checkNum - numB
        return diffA < diffB
    }

    private fun getDirectoryFileSize(dir : Directory) {
        dir.lstChildrenFiles.forEach { child ->
            dir.size += child.size
        }
        dir.lstChildrenDirectories.forEach {
            getDirectoryFileSize(it)
        }
    }

    private fun getDirectoryFileSizeWithChildren(dir : Directory) : Int{
        dir.lstChildrenFiles.forEach { child ->
            dir.size += child.size
        }
        dir.lstChildrenDirectories.forEach {
            dir.size += getDirectoryFileSizeWithChildren(it)
        }
        return dir.size
    }

}



abstract class Directory (val name : String, val lstChildrenFiles : MutableList<File>, var size : Int, val lstChildrenDirectories : MutableList<Directory>) {
    abstract fun clone() : Directory
    override fun toString() : String = name
}
class SubDirectory (name : String, val parent : Directory, lstChildren : MutableList<File> , lstChildrenDirectories : MutableList<Directory>) : Directory(name, lstChildren, 0 , lstChildrenDirectories){
    override fun clone(): SubDirectory {
        return SubDirectory(name, parent, lstChildrenFiles, lstChildrenDirectories)
    }
}
class MainDirectory (name : String, lstChildren : MutableList<File> , lstChildrenDirectories : MutableList<Directory>) : Directory(name, lstChildren,0 , lstChildrenDirectories) {
    override fun clone(): Directory {
        return MainDirectory(name, lstChildrenFiles, lstChildrenDirectories)
    }
}

class File (val name : String, val size : Int){

    override fun toString() : String = name
}

