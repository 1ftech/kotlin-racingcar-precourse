package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    val carNames = try {
        println("Enter the names of the cars (comma-separated):")
        val carNamesInput = Console.readLine()
        InputHandler.parseCarNames(carNamesInput)
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
        return
    }

    val totalRounds = try {
        println("How many rounds will be played?")
        val roundsInput = Console.readLine()
        InputHandler.parseRoundCount(roundsInput)
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
        return
    }

    val cars = carNames.map { Car(it) }
    val game = RacingGame(cars, totalRounds)

    println("\nRace Results")
    game.start()
    game.printWinners()
}