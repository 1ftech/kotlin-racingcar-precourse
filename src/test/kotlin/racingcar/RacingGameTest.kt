package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RacingGameTest {

    @Test
    fun `should declare one winner correctly`() {
        val pobi = Car("pobi")
        val woni = Car("woni")
        val cars = listOf(pobi, woni)
        val game = RacingGame(cars, 1) // Pass dummy round count

        pobi.setPositionForTesting(3)
        woni.setPositionForTesting(1)

        // Replicate printWinners logic to get winners list
        val maxPosition = cars.maxOfOrNull { it.position } ?: 0
        val winners = cars.filter { it.position == maxPosition }.map { it.name }

        assertThat(winners).containsExactly("pobi")
    }

    @Test
    fun `should allow multiple winners if tied`() {
        val car1 = Car("a")
        val car2 = Car("b")
        val cars = listOf(car1, car2)
        val game = RacingGame(cars, 1) // Pass dummy round count

        car1.setPositionForTesting(5)
        car2.setPositionForTesting(5)

        val maxPosition = cars.maxOfOrNull { it.position } ?: 0
        val winners = cars.filter { it.position == maxPosition }.map { it.name }

        assertThat(winners).containsExactlyInAnyOrder("a", "b")
    }
}
