package racingcar

import camp.nextstep.edu.missionutils.Randoms

/**
 * Represents a car in the racing game.
 * @property name The name of the car, should be validated by InputHandler.
 * @property position The current position of the car in the race, starting from 0.
 */
class Car(val name: String) {
    var position: Int = 0
        private set

    companion object {
        private const val MOVE_THRESHOLD = 4
        private const val MIN_RANDOM_NUMBER = 0
        private const val MAX_RANDOM_NUMBER = 9
    }

    /**
     * Attempts to move the car forward.
     * The car moves one step if a randomly generated number (0-9) is greater than or equal to MOVE_THRESHOLD.
     */
    fun move() {
        val randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER)
        if (randomNumber >= MOVE_THRESHOLD) {
            position++
        }
    }

    /**
     * Returns a string representation of the car's progress.
     * Progress is represented by a hyphen '-' for each position unit.
     * @return A string of hyphens indicating the car's current position. For example, if position is 3, returns "---".
     */
    fun getProgress(): String {
        return "-".repeat(position)
    }

    /**
     * Sets the car's position directly for testing purposes.
     * This method is intended only for use in test code.
     * @param newPosition The new position to set for the car. Must be non-negative.
     * @throws IllegalArgumentException if newPosition is negative.
     */
    internal fun setPositionForTesting(newPosition: Int) {
        require(newPosition >= 0) { "Position cannot be negative." }
        this.position = newPosition
    }
}
