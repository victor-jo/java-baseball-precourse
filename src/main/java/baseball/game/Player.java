package baseball.game;

import baseball.context.Numbers;
import baseball.io.Printer;
import baseball.io.ConsolePrinter;
import baseball.util.NumbersValidator;
import camp.nextstep.edu.missionutils.Console;

public class Player {

    private final Printer printer;

    public Player(Printer printer) {
        this.printer = printer;
    }

    public Numbers present() {
        return printAndGetNumbers();
    }

    private Numbers printAndGetNumbers() {
        printer.print("숫자를 입력해주세요 : ");
        char[] rawNumbers = Console.readLine().toCharArray();
        NumbersValidator.validate(rawNumbers);
        return Numbers.valueOf(rawNumbers);
    }

    public static Player create() {
        return new Player(
            new ConsolePrinter()
        );
    }
}
