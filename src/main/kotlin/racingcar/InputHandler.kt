package racingcar

/**
 * Provides utility functions for parsing and validating user input for the racing game.
 */
object InputHandler {

    private const val MAX_CAR_NAME_LENGTH = 5

    /**
     * Parses a comma-separated string of car names into a list of strings.
     * Validates that names are non-empty and do not exceed MAX_CAR_NAME_LENGTH characters after trimming.
     * @param input The raw string input for car names.
     * @return A list of valid car names.
     * @throws IllegalArgumentException if input is invalid (e.g., empty names, names too long, or empty overall input).
     */
    fun parseCarNames(input: String): List<String> {
        val names = input.split(",").map { it.trim() }
        if (names.isEmpty() || names.any { it.isEmpty() || it.length > MAX_CAR_NAME_LENGTH }) {
            throw IllegalArgumentException("Car names must be non-empty and up to $MAX_CAR_NAME_LENGTH characters.")
        }
        return names
    }

    /**
     * Parses a string input into an integer representing the number of rounds.
     * Validates that the input is a number and is greater than zero.
     * @param input The raw string input for the number of rounds.
     * @return The parsed and validated number of rounds.
     * @throws IllegalArgumentException if input is not a valid positive integer.
     */
    fun parseRoundCount(input: String): Int {
        val rounds = input.toIntOrNull()
            ?: throw IllegalArgumentException("Round count must be a number.")
        if (rounds <= 0) throw IllegalArgumentException("Round count must be greater than zero.")
        return rounds
    }
}
