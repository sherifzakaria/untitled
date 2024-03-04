package algoexpert

class Question51ZeroSumSubarray {
    fun zeroSumSubarray(nums: List<Int>): Boolean {
        // Write your code here.
        if (nums.isEmpty()) return false
        if (nums.sum() == 0) return true

        val sumToIndex = mutableSetOf<Int>()
        var currentSum = nums[0]
        sumToIndex.add(currentSum)

        for (i in 1 until nums.size) {
            currentSum += nums[i]
            if (sumToIndex.contains(currentSum)) return true else sumToIndex.add(currentSum)
        }

        return false
    }
}

fun main() {
    println(Question51ZeroSumSubarray().zeroSumSubarray(listOf(-5, -5, 2, 3, -2)))
}