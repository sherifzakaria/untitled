package algoexpert

import kotlin.math.min

class Question47OptimalFreelancing {
    fun optimalFreelancing(jobs: MutableList<Map<String, Int>>): Int {
        // Write your code here.
        val profitsMap = mutableMapOf<Int, Int>()
        jobs.sortByDescending { it["payment"] }

        for (job in jobs) {
            if (profitsMap.size == 7) break
            var currentJobDeadline = job["deadline"]!!
            while (currentJobDeadline > 7 && profitsMap[currentJobDeadline] != null) {
                currentJobDeadline--
            }
            if (currentJobDeadline < 1) break

            while (currentJobDeadline > 0 && profitsMap[currentJobDeadline] != null) {
                currentJobDeadline--
            }
            if (currentJobDeadline > 0 && profitsMap[currentJobDeadline] == null) {
                profitsMap[currentJobDeadline] = job["payment"]!!
            }
        }

        return profitsMap.values.sum()
    }

    fun optimalFreelancing2(jobs: MutableList<Map<String, Int>>): Int {
        // Write your code here.
        var profit = 0
        val lengthOfWeek = 7
        val timeline = MutableList(lengthOfWeek) { false }

        jobs.sortByDescending { it["payment"] }

        for (job in jobs) {
            val maxtime = min(job["deadline"]!!, lengthOfWeek)
            for (time in maxtime - 1 downTo 0) {
                if (!timeline[time]) {
                    profit += job["payment"]!!
                    timeline[time] = true
                    break
                }
            }
        }

        return profit
    }
}

fun main() {
    val input = mutableListOf(
        mapOf("deadline" to 1, "payment" to 4), // 1
        mapOf("deadline" to 5, "payment" to 4), // 5
        mapOf("deadline" to 1, "payment" to 3),
        mapOf("deadline" to 4, "payment" to 3), // 4
        mapOf("deadline" to 3, "payment" to 2), // 3
        mapOf("deadline" to 4, "payment" to 2), // 2
        mapOf("deadline" to 2, "payment" to 1),
        mapOf("deadline" to 4, "payment" to 1),
        mapOf("deadline" to 8, "payment" to 1) // 6
    )

    val input2 = mutableListOf(
        mapOf("deadline" to 1, "payment" to 1), // 1
        mapOf("deadline" to 2, "payment" to 1), // 5
        mapOf("deadline" to 3, "payment" to 1),
        mapOf("deadline" to 4, "payment" to 1), // 4
        mapOf("deadline" to 5, "payment" to 1), // 3
        mapOf("deadline" to 6, "payment" to 1), // 2
        mapOf("deadline" to 7, "payment" to 1),
        mapOf("deadline" to 8, "payment" to 1),
        mapOf("deadline" to 9, "payment" to 1), // 6
        mapOf("deadline" to 10, "payment" to 1) // 6
    )

    println(Question47OptimalFreelancing().optimalFreelancing2(jobs = input))
    println(Question47OptimalFreelancing().optimalFreelancing2(jobs = input2))
}