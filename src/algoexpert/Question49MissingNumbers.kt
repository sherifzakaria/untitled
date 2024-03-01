package algoexpert

class Question49MissingNumbers {
    fun missingNumbers(nums: MutableList<Int>): List<Int> {
        // Write your code here.
        val missingList = mutableListOf<Int>()

        if (nums.isEmpty()) {
            missingList.add(1)
            missingList.add(2)
            return missingList
        }

        nums.sort()

        for (i in 1 until nums.size) {
            if (nums[i] > nums[i - 1] + 1) {
                missingList.add(nums[i] - 1)
            }

            if (missingList.size == 2) return missingList
        }

        var index = 1
        while (missingList.size < 2) {
            missingList.add(nums[nums.size - 1] + index)
            index++
        }

        return missingList
    }
}

fun main() {
    val input = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 10)
    val input2 = mutableListOf(1, 4, 3)
    val output = Question49MissingNumbers().missingNumbers(input)
    println(Question49MissingNumbers().missingNumbers(input2))
    println(output)
}