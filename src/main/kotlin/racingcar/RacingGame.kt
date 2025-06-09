package racingcar

/**
 * Manages the state and progression of a racing car game.
 * @param cars The list of [Car] objects participating in the game.
 * @param totalRounds The total number of rounds the game will last.
 */
class RacingGame(private val cars: List<Car>, private val totalRounds: Int) {

    /**
     * Starts and runs the racing game for the total number of rounds.
     * In each round, all cars attempt to move, and the results of the round are printed.
     */
    fun start() {
        repeat(totalRounds) {
            cars.forEach { it.move() }
            printRoundResults()
            println()
        }
    }

    /**
     * Prints the current progress (name and position visualization) of each car.
     * Called after each round.
     */
    private fun printRoundResults() {
        cars.forEach { car ->
            println("${car.name} : ${car.getProgress()}")
        }
    }

    /**
     * Determines and prints the names of the car(s) that are in the leading position(s) at the end of the game.
     * Multiple winners are possible if they are tied for the maximum position.
     */
    fun printWinners() {
        val maxPosition = cars.maxOf { it.position }
        val winners = cars.filter { it.position == maxPosition }.map { it.name }
        println("Winners : ${winners.joinToString(", ")}")
    }
}
