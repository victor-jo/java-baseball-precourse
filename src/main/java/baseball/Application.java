package baseball;

import baseball.game.Computer;
import baseball.game.Game;
import baseball.game.GameRestartPolicy;
import baseball.game.GameStarter;
import baseball.game.Player;

public class Application {
    public static void main(String[] args) {
        Game game = new Game(
            Computer.create(),
            Player.create(),
            GameRestartPolicy.create()
        );
        new GameStarter(game).start();
    }
}
