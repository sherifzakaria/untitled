package algoexpert

class Question47OptimalFreelancing {
    fun optimalFreelancing(jobs: MutableList<Map<String, Int>>): Int {
        // Write your code here.
        var result = 0
        var day = 1

        val sortedJobs = jobs.sortedWith(
            compareByDescending<Map<String, Int>> { it["payment"] }
        )

        println(sortedJobs)

        for (job in sortedJobs) {
            if (job["deadline"]!! >= day) {
                result += job["payment"]!!
                day++
            }

            if (day == 8) {
                break
            }
        }

        return result
    }
}

fun main() {
    val input = mutableListOf(
        mapOf("deadline" to 2, "payment" to 1), //1
        mapOf("deadline" to 1, "payment" to 4), //4
        mapOf("deadline" to 3, "payment" to 2), //2
        mapOf("deadline" to 1, "payment" to 3),
        mapOf("deadline" to 4, "payment" to 3), //3
        mapOf("deadline" to 4, "payment" to 2),
        mapOf("deadline" to 4, "payment" to 1),
        mapOf("deadline" to 5, "payment" to 4), //4
        mapOf("deadline" to 8, "payment" to 1) //1
    )

    println(Question47OptimalFreelancing().optimalFreelancing(jobs = input))
}