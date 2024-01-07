package algoexpert

class Question48BestSeat {
    fun bestSeat(seats: MutableList<Int>): Int {
        // Write your code here.
        var emptySeatsCounter = 0
        var maxEmptySeats = 0
        var bestSeatIndex = -1
        for (seatIndex in 1 until seats.size) {
            if (seats[seatIndex] == 0) {
                emptySeatsCounter += 1
                if (emptySeatsCounter > maxEmptySeats) {
                    maxEmptySeats = emptySeatsCounter
                    bestSeatIndex = seatIndex - (emptySeatsCounter / 2)
                }
            } else {
                emptySeatsCounter = 0
            }
        }

        if (bestSeatIndex != -1) return bestSeatIndex

        for (seat in seats.withIndex()) {
            if (seat.value == 0) {
                return seat.index
            }
        }

        return bestSeatIndex
    }
}

fun main() {

    println(Question48BestSeat().bestSeat(mutableListOf(1, 0, 1, 0, 0, 0, 1)))
    println(Question48BestSeat().bestSeat(mutableListOf(1, 0, 1)))
    println(Question48BestSeat().bestSeat(mutableListOf(1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1)))
}