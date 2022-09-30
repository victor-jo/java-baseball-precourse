package baseball;

import baseball.factory.ComputerFactory;
import baseball.factory.GameRestartPolicyFactory;
import baseball.factory.PlayerFactory;
import baseball.game.Computer;
import baseball.game.Game;
import baseball.game.GameRestartPolicy;
import baseball.game.GameStarter;
import baseball.game.Player;

public class Application {
    public static void main(String[] args) {
        Game game = new Game(
            ComputerFactory.create(),
            PlayerFactory.create(),
            GameRestartPolicyFactory.create()
        );
        new GameStarter(game).start();
    }
}
