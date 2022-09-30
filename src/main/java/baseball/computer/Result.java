package baseball.computer;

import baseball.context.Printer;

public class Result {

    private int ball = 0;
    private int strike = 0;

    public Result(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public void addBall() {
        this.ball += 1;
    }

    public void addStrike() {
        this.strike += 1;
    }

    public boolean hasBall() {
        return this.ball > 0;
    }

    public boolean hasStrike() {
        return this.strike > 0;
    }

    public boolean nothing() {
        return this.ball == 0 && this.strike == 0;
    }

    public void print(Printer printer) {
        ResultMessage resultMessage = new ResultMessage(this);
        printer.println(resultMessage.toString());
    }

    public String toBallString() {
        return this.ball + "볼";
    }

    public String toStrikeString() {
        return this.strike + "스트라이크";
    }

    public String toNothingString() {
        return "낫싱";
    }

    public boolean isPerfect() {
        return this.strike == 3;
    }
}
