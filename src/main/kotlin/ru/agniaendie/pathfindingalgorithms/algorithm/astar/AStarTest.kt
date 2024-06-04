package ru.agniaendie.pathfindingalgorithms.algorithm.astar

import ru.agniaendie.pathfindingalgorithms.graph.Edge
import ru.agniaendie.pathfindingalgorithms.graph.Node
import java.util.LinkedList
import java.util.PriorityQueue
import java.util.Queue

class AStarTest {
    lateinit var startElem: Node

    lateinit var endElem: Node

    fun prepareTest() {
        val b0 = Node("B0")

        val b3 = Node("B3")

        val b2 = Node("B2")

        val b1 = Node("B1")

        val a3 = Node("A3")

        val a2 = Node("A2")

        val a1 = Node("A1")

        val a0 = Node("A0")

        val a0Toa1 = Edge(1, a0, a1)
        val a0Toa2 = Edge(1, a0, a2)
        val a0Toa3 = Edge(1, a0, a3)

        val a1Tob3 = Edge(1, a1, b3)
        val a1Tob1 = Edge(1, a1, b1)

        val a2Tob2 = Edge(2, a2, b2)

        val a3ToB1 = Edge(1, a3, b1)

        val b1Tob0 = Edge(2, b1, b0)
        val b2Tob0 = Edge(4, b2, b0)
        val b3Tob0 = Edge(3, b3, b0)

        a0.edges = listOf(a0Toa1, a0Toa2, a0Toa3)

        a1.edges = listOf(a0Toa1, a1Tob1, a1Tob3)
        a2.edges = listOf(a0Toa2, a2Tob2)
        a3.edges = listOf(a0Toa3, a3ToB1)

        b1.edges = listOf(a1Tob1, a3ToB1, b1Tob0)
        b2.edges = listOf(a2Tob2, b2Tob0)
        b3.edges = listOf(a1Tob3, b3Tob0)

        b0.edges = listOf(b1Tob0, b2Tob0, b3Tob0)
        startElem = a0
        endElem = b0
    }

    fun findPathBFS(start: Node,end:Node): MutableList<Node> {
        val visited = mutableListOf<Node>()
        val queue: Queue<Node> = LinkedList()
        val parentMap = mutableMapOf<Node, Node?>()
        parentMap[start] = null
        queue.add(start)
        visited.add(start)

        while(queue.isNotEmpty()){

            val current = queue.remove()



            current.edges?.forEach {
                if(it.to !in visited){
                    queue.add(it.to)
                    visited.add(it.to)
                    println(it.to.name)
                }
            }
        }

        return visited
    }
    fun testFindPathBFS(start: Node, end: Node): MutableList<Node> {
        val visited = mutableSetOf<Node>()
        val queue: Queue<Node> = LinkedList()
        val parentMap = mutableMapOf<Node, Node?>()
        parentMap[start] = null
        queue.add(start)
        visited.add(start)

        while (queue.isNotEmpty()) {
            val current = queue.remove()

            if (current == end) {
                // Reconstruct the path from end to start
                val path = mutableListOf<Node>()
                var at: Node? = end
                while (at != null) {
                    path.add(at)
                    at = parentMap[at]
                }
                path.reverse()
                return path
            }

            current.edges?.forEach { edge ->
                if (edge.to !in visited) {
                    queue.add(edge.to)
                    visited.add(edge.to)
                    parentMap[edge.to] = current
                }
            }
        }

        return mutableListOf() // If no path is found
    }
    fun getResult() {
        //val visited = findPathBFS(startElem,endElem)
        val visited = testFindPathBFS(startElem,endElem)
        for(elem in visited){
            println(elem.name)
        }
    }

}
