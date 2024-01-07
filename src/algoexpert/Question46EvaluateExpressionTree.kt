package algoexpert

// This is an input class. Do not edit.
open class BinaryTree(value: Int) {
    var value = value
    var left: BinaryTree? = null
    var right: BinaryTree? = null
}

fun evaluateExpressionTree2(tree: BinaryTree): Int {
    // Write your code here.
    if (tree.value >= 0) return tree.value

    val leftValue = evaluateExpressionTree(tree.left!!)
    val righValue = evaluateExpressionTree(tree.right!!)

    return when (tree.value) {
        -1 -> leftValue + righValue
        -2 -> leftValue - righValue
        -3 -> leftValue / righValue
        else -> leftValue * righValue
    }
}

fun evaluateExpressionTree(tree: BinaryTree): Int {
    // Write your code here.
    val stack = ArrayDeque<String>()
    preorder(tree, stack)
    val result = stack.removeFirst().toInt()
    return result
}

private fun preorder(tree: BinaryTree, stack: ArrayDeque<String>) {
    var result = 0
    if (tree.left != null) {
        preorder(tree.left!!, stack)
    }

    stack.addFirst(tree.value.toString())

    if (tree.right != null) {
        preorder(tree.right!!, stack)
    }

    if (tree.value < 0) {
        val rightOperand = stack.removeFirst().toInt()
        val operator = stack.removeFirst()
        val leftOperand = stack.removeFirst().toInt()

        when (operator) {
            "-1" -> result = leftOperand + rightOperand
            "-2" -> result = leftOperand - rightOperand
            "-3" -> result = leftOperand / rightOperand
            "-4" -> result = leftOperand * rightOperand
        }

        stack.addFirst(result.toString())
    }
}

fun main() {
//    val tree = BinaryTree(-1)
//    tree.left = BinaryTree(2)
//    tree.right = BinaryTree(-2)
//    tree.right!!.left = BinaryTree(5)
//    tree.right!!.right = BinaryTree(1)

    val tree = BinaryTree(-1)
    tree.left = BinaryTree(-2)
    tree.right = BinaryTree(-4)
    tree.left!!.left = BinaryTree(7)
    tree.left!!.right = BinaryTree(10)
    tree.right!!.left = BinaryTree(12)
    tree.right!!.right = BinaryTree(-3)
    tree.right!!.right!!.left = BinaryTree(8)
    tree.right!!.right!!.right = BinaryTree(4)

    println(evaluateExpressionTree(tree))
    println(evaluateExpressionTree2(tree))
}