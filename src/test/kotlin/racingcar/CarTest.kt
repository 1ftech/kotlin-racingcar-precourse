package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest : NsTest() {

    companion object {
        private const val MOVING_FORWARD_CONDITION = 4
        private const val STOP_CONDITION = 3
    }

    @Test
    fun `move_advances_position_when_random_number_is_above_threshold`() {
        val car = Car("testCar")
        assertRandomNumberInRangeTest(
            { car.move() },
            MOVING_FORWARD_CONDITION
        )
        assertThat(car.position).isEqualTo(1)
    }

    @Test
    fun `move_does_not_advance_position_when_random_number_is_below_threshold`() {
        val car = Car("testCar")
        assertRandomNumberInRangeTest(
            { car.move() },
            STOP_CONDITION
        )
        assertThat(car.position).isEqualTo(0)
    }

    @Test
    fun `getProgress_returns_correct_number_of_hyphens`() {
        val car = Car("testCar")
        assertRandomNumberInRangeTest(
            {
                car.move() // pos = 1
                car.move() // pos = 2
            },
            MOVING_FORWARD_CONDITION, MOVING_FORWARD_CONDITION
        )
        assertThat(car.getProgress()).isEqualTo("--")

        // Test for position 0
        val car2 = Car("noMoveCar")
        assertThat(car2.getProgress()).isEqualTo("")
    }

    override fun runMain() {
        // Not used in this unit test file, but NsTest requires it.
    }
}
