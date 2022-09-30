package baseball;

import baseball.computer.Computer;
import baseball.game.Game;
import baseball.game.GameRestartPolicy;
import baseball.game.GameStarter;
import baseball.player.Player;
import baseball.player.PlayerNumbersValidator;
import baseball.printer.ConsolePrinter;

public class Application {
    public static void main(String[] args) {
        Game game = new Game(
            new Computer(
                new ConsolePrinter()
            ),
            new Player(
                new ConsolePrinter(),
                new PlayerNumbersValidator()
            ),
            new GameRestartPolicy(
                new ConsolePrinter()
            )
        );
        new GameStarter(game).start();
    }
}
