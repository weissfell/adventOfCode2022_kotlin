package main.kotlin

import main.kotlin.generalutils.ChristmasFileReader

class Day11Dijkstra(val src: String) {
    val strLines = ChristmasFileReader(src).fetchLinesAsString()
    val nodeList = mutableListOf<MutableList<Node>>()

    init {
        var x = 0
        strLines.forEach { line ->
            var y = 0
            nodeList.add(mutableListOf())
            line.forEach { level ->
                if (level == 'S') {
                    val node = Node(x, y, 'a'.code)
                    node.isStart = true
                    node.distance = 0
                    nodeList[x].add(node)
                } else if (level == 'E') {
                    val node = Node(x, y, 'z'.code)
                    node.isEnd = true
                    nodeList[x].add(node)
                } else
                    nodeList[x].add(Node(x, y, level.code))
                y++
            }

            x++
        }
    }

    val unvisited = mutableListOf<Node>()
    val visited = mutableListOf<Node>()

    fun partOne(): Int {
        doDijkstra()

        return getFinishNode()
    }

    fun partTwo(): Int{
        unvisited.clear()
        visited.clear()
        nodeList.forEach {
            it.forEach { innerIt ->
                innerIt.distance = Int.MIN_VALUE
                if(innerIt.isEnd) innerIt.distance = 0
                innerIt.height = innerIt.height * -1

            }
        }
        doDijkstra()
        return getMinA()
    }

    private fun doDijkstra(){
        nodeList.forEach {
            it.forEach { innerIt ->
                unvisited.add(innerIt)
            }
        }

        var prevNode : Node? = null
        while (unvisited.isNotEmpty()) {
            val currNode = getMinNode(prevNode, visited) ?: break
            prevNode = currNode
            unvisited.remove(currNode)
            visited.add(currNode)

            if (currNode.x > 0)
                setNeighborDistance(nodeList[currNode.x - 1][currNode.y], currNode, visited)
            if (currNode.x < nodeList.size - 1)
                setNeighborDistance(nodeList[currNode.x + 1][currNode.y], currNode, visited)
            if (currNode.y > 0)
                setNeighborDistance(nodeList[currNode.x][currNode.y - 1], currNode, visited)
            if (currNode.y < nodeList[0].size - 1)
                setNeighborDistance(nodeList[currNode.x][currNode.y + 1], currNode, visited)

        }

    }

    private fun setNeighborDistance( neighbor: Node, currNode: Node, visited: MutableList<Node>) {
        if (visited.contains(neighbor)) return
        if (neighbor.height - currNode.height == 1 || neighbor.height - currNode.height == 0 || neighbor.height - currNode.height < 0) {
            val newDistance = currNode.distance + 1
            if (neighbor.distance <= 0 || newDistance < neighbor.distance) {
                neighbor.distance = newDistance
            }
        }
    }

    private fun getFinishNode() : Int {

        nodeList.forEach {
            it.forEach { innerIt ->
                if(innerIt.isEnd)
                    return innerIt.distance
            }
        }
        return 0
    }

    private fun getMinA() : Int {
        var resultNode : Node? = null
        nodeList.forEach {
            it.forEach { innerIt ->
                if(innerIt.distance < 0 || (innerIt.height * -1) != 'a'.code) return@forEach
                if(resultNode == null || resultNode!!.distance > innerIt.distance)
                    resultNode = innerIt
            }
        }
        if(resultNode != null) return resultNode!!.distance
        return 0
    }

    private fun getMinNode(prevNode : Node?, visited: MutableList<Node>): Node? {
        var minDistanceNode: Node? = null
        nodeList.forEach {
            it.forEach { innerIt ->
                if ((minDistanceNode == null || innerIt.distance < minDistanceNode!!.distance) &&
                    innerIt != prevNode && !visited.contains(innerIt) && innerIt.distance >= 0)
                    minDistanceNode = innerIt
            }
        }

        return minDistanceNode
    }
}

class Node(
    val x: Int, val y: Int, var height: Int, var distance: Int = Int.MIN_VALUE
) {
    var isStart = false
    var isEnd = false
    override fun toString(): String {
        return "Is End $isEnd - $distance"
    }
}