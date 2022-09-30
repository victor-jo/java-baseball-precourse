package baseball.player;

import baseball.context.NumbersValidator;

public class PlayerNumbersValidator implements NumbersValidator {
    @Override
    public void validateNumbers(char[] numbers) {
        validateNumbersType(numbers);
        validateNumbersLength(numbers);
    }

    private void validateNumbersType(char[] numbers) {
        boolean[] seen = new boolean[10];
        for (char number : numbers) {
            int real = number - '0';
            validateNumbersIsUniqueAndRealNumber(seen, real);
            seen[real] = true;
        }
    }

    private void validateNumbersLength(char[] numbers) {
        if (numbers.length != 3) {
            throw new IllegalArgumentException("제시된 숫자가 3자리가 아닙니다.");
        }
    }

    private void validateNumbersIsUniqueAndRealNumber(boolean[] seen, int real) {
        if (real < 1 || real > 9) {
            throw new IllegalArgumentException("1 ~ 9 까지의 숫자만 입력 가능합니다.");
        }
        if (seen[real]) {
            throw new IllegalArgumentException("서로 다른 숫자만 입력 가능합니다.");
        }
    }
}
