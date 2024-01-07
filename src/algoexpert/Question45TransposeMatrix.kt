package algoexpert

class Question45TransposeMatrix {
    fun transposeMatrix(matrix: MutableList<MutableList<Int>>): MutableList<MutableList<Int>> {
        // Write your code here.
        val rowSize = matrix.size
        val colSize = matrix[0].size
        val result = MutableList(colSize) { MutableList(rowSize) { 0 } }
        for (rowIndex in 0 until rowSize) {
            for (colIndex in 0 until colSize) {
                result[colIndex][rowIndex] = matrix[rowIndex][colIndex]
            }
        }
        return result
    }

    fun transposeMatrix2(matrix: MutableList<MutableList<Int>>): MutableList<MutableList<Int>> {
        // Write your code here.
        val transposeMatrix = mutableListOf<MutableList<Int>>()

        for (col in 0 until matrix[0].size) {
            val newRow = mutableListOf<Int>()
            for (row in 0 until matrix.size) {
                newRow.add(matrix[row][col])
            }
            transposeMatrix.add(newRow)
        }

        return transposeMatrix
    }
}

fun main() {
    val matrix = mutableListOf<MutableList<Int>>()
    matrix.add(mutableListOf(1, 2))
    matrix.add(mutableListOf(3, 4))
    matrix.add(mutableListOf(5, 6))
    println(matrix)
//    println(Question45TransposeMatrix().transposeMatrix(matrix))
    println(Question45TransposeMatrix().transposeMatrix2(matrix))
}