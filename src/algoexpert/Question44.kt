package algoexpert

// This is an input class. Do not edit.
open class LinkedList(value: Int) {
    var value = value
    var next: LinkedList? = null
}

fun middleNode(linkedList: LinkedList): LinkedList {
    // Write your code here.
    var oneStepPointer: LinkedList = linkedList
    var twoStepPointer: LinkedList? = linkedList
    while (twoStepPointer != null && twoStepPointer.next != null) {
        oneStepPointer = oneStepPointer.next!!
        twoStepPointer = twoStepPointer.next!!.next
    }
    return oneStepPointer
}


fun main() {

}