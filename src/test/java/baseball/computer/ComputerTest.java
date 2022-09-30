package baseball.computer;

import baseball.printer.ConsolePrinter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static baseball.util.TestUtil.getPrivateVariable;
import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {

    @Test
    @DisplayName("서로 다른 임의의 1 ~ 9 까지의 숫자를 생성한다.")
    void generateNumber() throws NoSuchFieldException, IllegalAccessException {
        Computer computer = new Computer(new ConsolePrinter());
        computer.generateNumber();

        char[] numbers = (char[]) getPrivateVariable(computer, "numbers");
        assertTrue(numbers[0] != numbers[1]);
        assertTrue(numbers[1] != numbers[2]);
        assertTrue(numbers[0] != numbers[2]);
    }

    @Test
    @DisplayName("플레이어와 컴퓨터의 숫자를 비교하여 볼, 스트라이크 결과를 생성한다.")
    void match() throws NoSuchFieldException, IllegalAccessException {
        Computer computer = new Computer(new ConsolePrinter());
        computer.generateNumber();

        char[] numbers = (char[]) getPrivateVariable(computer, "numbers");
        computer.match(numbers);

        Result result = (Result) getPrivateVariable(computer, "result");
        assertTrue(result.isPerfect());
    }

    @Test
    @DisplayName("생성된 결과가 스트라이크 '3'이면 컴퓨터가 패배한다.")
    void lose() throws NoSuchFieldException, IllegalAccessException {
        Computer computer = new Computer(new ConsolePrinter());
        computer.generateNumber();

        char[] numbers = (char[]) getPrivateVariable(computer, "numbers");
        computer.match(numbers);

        assertTrue(computer.lose());
    }
}