package baseball.game;

import baseball.computer.Computer;
import baseball.context.GameCycle;
import baseball.context.RestartPolicy;
import baseball.player.Player;

public class Game implements GameCycle {

    private final Computer computer;
    private final Player player;
    private final RestartPolicy restartPolicy;

    public Game(Computer computer, Player player, RestartPolicy restartPolicy) {
        this.computer = computer;
        this.player = player;
        this.restartPolicy = restartPolicy;
    }

    public boolean playable = true;

    @Override
    public void onPlay() {
        char[] numbers = player.present();
        computer.match(numbers);
        computer.printResult();
    }

    @Override
    public void onEnd() {
        restartPolicy.restart(computer.lose(),
            this::onRefresh,
            this::onExit);
    }

    @Override
    public void onRefresh() {
        computer.generateNumber();
    }

    public void onExit() {
        this.playable = false;
    }
}
