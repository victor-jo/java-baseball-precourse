package baseball.computer;

import baseball.context.Printer;
import camp.nextstep.edu.missionutils.Randoms;

public class Computer {

    private final Printer resultPrinter;

    public Computer(Printer resultPrinter) {
        this.resultPrinter = resultPrinter;
    }

    private char[] numbers;
    private Result result;

    public void generateNumber() {
        boolean[] seen = new boolean[10];
        numbers = new char[3];
        for (int i = 0; i < numbers.length; i++) {
            int number = getGeneratedOne(seen);
            seen[number] = true;
            numbers[i] = (char) (number + '0');
        }
    }

    private int getGeneratedOne(boolean[] seen) {
        int random;
        do {
            random = Randoms.pickNumberInRange(1, 9);
        }
        while (seen[random]);
        return random;
    }

    public void match(char[] numbers) {
        result = new Result(0, 0);
        for (int i = 0; i < this.numbers.length; i++) {
            match(this.numbers, i, numbers);
        }
    }

    private void match(char[] numbers1, int i, char[] numbers2) {
        for (int j = 0; j < numbers2.length; j++) {
            match(numbers1, i, numbers2, j);
        }
    }

    private void match(char[] numbers1, int i, char[] numbers2, int j) {
        if (numbers1[i] == numbers2[j] && i == j) {
            result.addStrike();
        }
        if (numbers1[i] == numbers2[j] && i != j) {
            result.addBall();
        }
    }

    public void printResult() {
        this.result.print(this.resultPrinter);
    }

    public boolean lose() {
        return this.result.isPerfect();
    }
}
