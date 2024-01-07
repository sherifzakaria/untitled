package algoexpert

import java.util.*
import kotlin.collections.ArrayDeque

fun main() {
    val root = Node("A")
    root.children.add(Node("B"))
    root.children.add(Node("C"))
    root.children.add(Node("D"))
    root.children[0].children.add(Node("E"))
    root.children[0].children.add(Node("F"))
    root.children[2].children.add(Node("G"))
    root.children[2].children.add(Node("H"))
    root.children[0].children[1].children.add(Node("I"))
    root.children[0].children[1].children.add(Node("J"))
    root.children[2].children[0].children.add(Node("K"))

//    println(root.breadthFirstSearch())
    println(root.depthFirstSearch1())
}

class Node(name: String) {
    val name: String = name
    val children = mutableListOf<Node>()

    fun breadthFirstSearch(): List<String> {
        // Write your code here.
        val queue: Queue<Node> = LinkedList()
        queue.add(this)
        val result = mutableListOf<String>()
        while (queue.isNotEmpty()) {
            val node = queue.poll()
            result.add(node.name)
            queue.addAll(node.children)
        }
        return result
    }

    fun depthFirstSearch1(): List<String> {
        // Write your code here.
        return depthFirstSearch1(mutableListOf())
    }

    private fun depthFirstSearch1(mutableList: MutableList<String>): List<String> {
        // Write your code here.
        mutableList.add(this.name)
        this.children.forEach {
            it.depthFirstSearch1(mutableList)
        }
        return mutableList
    }

    fun depthFirstSearch(): List<String> {
        val result = mutableListOf<String>()
        result.add(this.name)
        this.children.forEach {
            result.addAll(it.depthFirstSearch())
        }
        return result
    }
}