package baseball.printer;

import baseball.context.Printer;

public class ConsolePrinter implements Printer {
    @Override
    public void print(String message) {
        System.out.print(message);
    }

    @Override
    public void println(String message) {
        print(message);
        System.out.println();
    }
}
