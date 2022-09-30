package baseball.player;

import baseball.context.NumbersValidator;
import baseball.context.Printer;
import baseball.printer.ConsolePrinter;
import camp.nextstep.edu.missionutils.Console;

public class Player {

    private final Printer printer;
    private final NumbersValidator validator;

    public Player(Printer printer, NumbersValidator validator) {
        this.printer = printer;
        this.validator = validator;
    }

    public char[] present() {
        char[] numbers = printAndGetNumbers();
        validator.validateNumbers(numbers);
        return numbers;
    }

    private char[] printAndGetNumbers() {
        printer.print("숫자를 입력해주세요 : ");
        return Console.readLine().toCharArray();
    }

    public static Player create() {
        return new Player(
            new ConsolePrinter(),
            new PlayerNumbersValidator()
        );
    }
}
