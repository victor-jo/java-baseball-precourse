package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtil {

    public static int getNumber() {
        return Randoms.pickNumberInRange(1, 9);
    }
}
