package algoexpert

class Question50TaskAssignment {
    fun taskAssignment(k: Int, tasks: List<Int>): List<List<Int>> {
        // Write your code here.
        val result = MutableList<MutableList<Int>>(k) { mutableListOf() }
        val tasksMap = tasks.mapIndexed { index, value -> index to value }.toMap().toMutableMap()
        val sortedTasksMap = tasksMap.entries.sortedBy { it.value }.associate { it.toPair() }.toMap()

        var workerIndex = -1
        var counter = 1
        for (task in sortedTasksMap.keys){
            workerIndex += counter
            if (workerIndex % k == 0 && workerIndex != 0) {
                counter *= -1
                workerIndex += counter
            }
            result[workerIndex].add(task)
        }

        return result
    }
}

fun main() {
    println(Question50TaskAssignment().taskAssignment(3, listOf(1, 3, 5, 3, 1, 4)))
}