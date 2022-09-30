package baseball.context;

import camp.nextstep.edu.missionutils.Randoms;

import static baseball.context.ResultType.*;

public class Numbers {

    private int number1;
    private int number2;
    private int number3;

    public static Numbers valueOf(char[] rawNumbers) {
        Numbers numbers = new Numbers();
        numbers.number1 = rawNumbers[0] - '0';
        numbers.number2 = rawNumbers[1] - '0';
        numbers.number3 = rawNumbers[2] - '0';
        return numbers;
    }

    public void random() {
        do {
            this.number1 = Randoms.pickNumberInRange(1, 9);
            this.number2 = Randoms.pickNumberInRange(1, 9);
            this.number3 = Randoms.pickNumberInRange(1, 9);
        }
        while (findSameNumberOnlyOne());
    }

    public boolean good() {
        return !findSameNumberOnlyOne();
    }

    private boolean findSameNumberOnlyOne() {
        return this.number1 == this.number2
            || this.number2 == this.number3
            || this.number1 == this.number3;
    }

    public ResultType firstResult(Numbers numbers) {
        return result(this.number1, numbers.number1, numbers.number2, numbers.number3);
    }

    public ResultType secondResult(Numbers numbers) {
        return result(this.number2, numbers.number2, numbers.number1, numbers.number3);
    }

    public ResultType thirdResult(Numbers numbers) {
        return result(this.number3, numbers.number3, numbers.number1, numbers.number2);
    }

    private ResultType result(int value, int same, int other1, int other2) {
        if (value == same) {
            return STRIKE;
        }
        if (value == other1 || value == other2) {
            return BALL;
        }
        return NOTHING;
    }
}
