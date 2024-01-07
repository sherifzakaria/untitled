package algoexpert

class Question43B {

    fun semordnilap(words: List<String>): List<List<String>> {
        // Write your code here.
        val result = mutableListOf<List<String>>()
        val seen = mutableSetOf<String>()

        words.forEach {
            val reversed = it.reversed()
            if (reversed in words && reversed !in seen && it != reversed) {
                result.add(listOf(it, reversed))
                seen.add(it)
                seen.add(reversed)
            }
        }
        return result
    }
}

fun main() {
    val words = listOf("diaper", "abc", "test", "cba", "repaid")
    println(Question43B().semordnilap(words))
}