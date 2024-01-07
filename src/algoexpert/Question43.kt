package algoexpert

class Question43 {

    fun semordnilap(words: List<String>): List<List<String>> {
        // Write your code here.
        val result = mutableListOf<List<String>>()
        val nonRepeatingSet = mutableSetOf<String>()
        nonRepeatingSet.add(words[0])
        words.forEach {
            if (!nonRepeatingSet.contains(it.getSemordnilap())) {
                nonRepeatingSet.add(it)
            } else {
                result.add(mutableListOf(it, it.getSemordnilap()))
            }
        }

        return result
    }

    private fun String.getSemordnilap(): String {
        val originalWord = this
        var semordnilap = ""
        originalWord.forEach {
            semordnilap = it.toString().plus(semordnilap)
        }
        return semordnilap
    }
}

fun main() {
    val words = listOf("diaper", "abc", "test", "cba", "repaid")
    println(Question43().semordnilap(words))
}