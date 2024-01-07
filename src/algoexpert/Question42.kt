package algoexpert

class Question42 {
    fun commonCharacters2(strings: MutableList<String>): List<String> {
        // get non-repeating characters in first string and change it back to a string
        val reducedChars = strings[0].toSet()

        var commonChars = reducedChars
        for (str in strings) {
            // get non-repeating characters in current string
            val currentChars = str.toSet()

            // get common characters between reducedChars and currentChars
            commonChars = commonChars.intersect(currentChars)
        }

        return commonChars.map { it.toString() }
    }

    fun commonCharacters(strings: MutableList<String>): List<String> {
        // get non-repeating characters in first string and change it back to a string
        var potentialCommonChar = strings[0].toSet().toMutableSet()

        for (str in strings) {
            // get non-repeating characters in current string
            val currentChars = str.toSet().toMutableSet()

            // get common characters between reducedChars and currentChars
            potentialCommonChar = potentialCommonChar.intersect(currentChars).toMutableSet()
        }

        return potentialCommonChar.map { it.toString() }
    }

    fun commonCharacters3(strings: MutableList<String>): List<String> {
        // get non-repeating characters in first string and change it back to a string
        val potentialCommonChar = strings[0].toSet().toMutableSet()

        for (str in strings) {
            // get non-repeating characters in current string
            val currentChars = str.toSet().toMutableSet()

            for (char in potentialCommonChar.toList()) {
                if (!currentChars.contains(char)) {
                    potentialCommonChar.remove(char)
                }
            }
        }

        return potentialCommonChar.map { it.toString() }
    }
}

fun main() {
    val strings = mutableListOf("abc", "bcd", "cbaccd")
    println(Question42().commonCharacters(strings))
    println(Question42().commonCharacters2(strings))
    println(Question42().commonCharacters3(strings))
}