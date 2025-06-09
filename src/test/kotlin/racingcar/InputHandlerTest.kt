package racingcar

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class InputHandlerTest {

    @Test
    fun `valid car names are parsed correctly`() {
        val result = InputHandler.parseCarNames("pobi,woni,jun")
        assertThat(result).containsExactly("pobi", "woni", "jun")
    }

    @Test
    fun `invalid car names throw exception`() {
        assertThatThrownBy { InputHandler.parseCarNames("pobi,wonilong,jun") }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `valid round count is parsed correctly`() {
        val result = InputHandler.parseRoundCount("5")
        assertThat(result).isEqualTo(5)
    }

    @Test
    fun `invalid round count throws exception`() {
        assertThatThrownBy { InputHandler.parseRoundCount("zero") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Round count must be a number.")
    }

    @Test
    fun `parseCarNames_trims_whitespace_and_parses_correctly`() {
        val result = InputHandler.parseCarNames("  pobi  ,  woni  ,  jun  ")
        assertThat(result).containsExactly("pobi", "woni", "jun")
    }

    @Test
    fun `parseCarNames_handles_single_car_name`() {
        val result = InputHandler.parseCarNames("pobi")
        assertThat(result).containsExactly("pobi")
    }

    @Test
    fun `parseCarNames_accepts_names_at_max_length`() {
        val result = InputHandler.parseCarNames("abcde,fghij,klmno")
        assertThat(result).containsExactly("abcde", "fghij", "klmno")
    }

    @Test
    fun `parseCarNames_throws_exception_for_empty_segments`() {
        assertThatThrownBy { InputHandler.parseCarNames("pobi,,jun") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Car names must be non-empty and up to 5 characters.")
    }

    @Test
    fun `parseCarNames_throws_exception_for_empty_input_string`() {
        assertThatThrownBy { InputHandler.parseCarNames("") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Car names must be non-empty and up to 5 characters.")
    }

    @Test
    fun `parseCarNames_throws_exception_for_only_commas`() {
        assertThatThrownBy { InputHandler.parseCarNames(",,,") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Car names must be non-empty and up to 5 characters.")
    }

    @Test
    fun `parseRoundCount_accepts_minimum_valid_round_count`() {
        val result = InputHandler.parseRoundCount("1")
        assertThat(result).isEqualTo(1)
    }

    @Test
    fun `parseRoundCount_throws_exception_for_zero_rounds`() {
        assertThatThrownBy { InputHandler.parseRoundCount("0") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Round count must be greater than zero.")
    }

    @Test
    fun `parseRoundCount_throws_exception_for_negative_rounds`() {
        assertThatThrownBy { InputHandler.parseRoundCount("-1") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Round count must be greater than zero.")
    }

    @Test
    fun `parseRoundCount_throws_exception_for_non_numeric_input_mixed`() {
        assertThatThrownBy { InputHandler.parseRoundCount("5a") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Round count must be a number.")
    }
}
