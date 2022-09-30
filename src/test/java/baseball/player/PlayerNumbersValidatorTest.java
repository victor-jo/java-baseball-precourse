package baseball.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PlayerNumbersValidatorTest {

    @Test
    @DisplayName("제시된 숫자는 1 ~ 9 사이의 숫자여야 한다.")
    void 제시된_숫자_범위검사() {
        char[] numbers = {'0', '1', '2'};
        PlayerNumbersValidator validator = new PlayerNumbersValidator();
        assertThatIllegalArgumentException()
            .isThrownBy(() -> validator.validateNumbers(numbers))
            .withMessage("1 ~ 9 까지의 숫자만 입력 가능합니다.");
    }

    @Test
    @DisplayName("서로 다른 숫자에 대해서만 입력이 가능하다.")
    void 제시된_숫자_유니크검사() {
        char[] numbers = {'1', '1', '2'};
        PlayerNumbersValidator validator = new PlayerNumbersValidator();
        assertThatIllegalArgumentException()
            .isThrownBy(() -> validator.validateNumbers(numbers))
            .withMessage("서로 다른 숫자만 입력 가능합니다.");
    }

    @Test
    @DisplayName("제시하는 숫자는 3자리 수만 가능하다.")
    void 제시된_숫자_길이검사() {
        char[] numbers = {'1', '2'};
        PlayerNumbersValidator validator = new PlayerNumbersValidator();
        assertThatIllegalArgumentException()
            .isThrownBy(() -> validator.validateNumbers(numbers))
            .withMessage("제시된 숫자가 3자리가 아닙니다.");
    }
}