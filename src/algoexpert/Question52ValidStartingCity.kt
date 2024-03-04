package algoexpert

class Question52ValidStartingCity {
    fun validStartingCity2(distances: List<Int>, fuel: List<Int>, mpg: Int): Int {
        // Write your code here.
        val milesPerFuel = fuel.map { it * mpg }

        var minimumStartingFuelCityIndex = -1
        var minimumStartingFuelCity = Int.MAX_VALUE
        var remainingFuel = 0

        for (i in distances.indices) {
            remainingFuel = remainingFuel + milesPerFuel[i] - distances[i]

            if (remainingFuel < minimumStartingFuelCity) {
                minimumStartingFuelCity = remainingFuel
                minimumStartingFuelCityIndex = i + 1
            }
        }

        if (minimumStartingFuelCityIndex > distances.indices.last) minimumStartingFuelCityIndex = 0

        return minimumStartingFuelCityIndex
    }

    fun validStartingCity(distances: List<Int>, fuel: List<Int>, mpg: Int): Int {
        // Write your code here.
        var startingCityCandidateIdx = 0
        var remainingMiles = 0
        var minimumRemainingMiles = 0

        for (cityIdx in 1 until distances.size) {
            remainingMiles += mpg * fuel[cityIdx - 1] - distances[cityIdx - 1]

            if (remainingMiles < minimumRemainingMiles){
                minimumRemainingMiles = remainingMiles
                startingCityCandidateIdx = cityIdx
            }
        }

        return startingCityCandidateIdx
    }
}

fun main() {

    println(
        Question52ValidStartingCity().validStartingCity(
            listOf(5, 25, 15, 10, 15),
            listOf(1, 2, 1, 0, 3),
            10
        )
    )

    println(
        Question52ValidStartingCity().validStartingCity(
            listOf(10, 20, 10, 15, 5, 15, 25),
            listOf(0, 2, 1, 0, 0, 1, 1),
            20
        )
    )

    println(
        Question52ValidStartingCity().validStartingCity(
            listOf(30, 25, 5, 100, 40),
            listOf(3, 2, 1, 0, 4),
            20
        )
    )
}
