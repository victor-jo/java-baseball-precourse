package baseball;

import baseball.computer.Computer;
import baseball.game.Game;
import baseball.game.GameRestartPolicy;
import baseball.game.GameStarter;
import baseball.player.Player;

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
