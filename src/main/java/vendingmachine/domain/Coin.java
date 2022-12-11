package vendingmachine.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    public static Map<Integer, Integer> moneyToChange(int money) {
        Map<Integer, Integer> changes = createChanges();
        while (money > 0) {
            int randomCoin = Randoms.pickNumberInList(createCoinNums());
            if (money - randomCoin < 0) {
                continue;
            }
            changes.put(randomCoin, changes.getOrDefault(randomCoin, 0) + 1);
            money -= randomCoin;
        }
        return changes;
    }

    private static Map<Integer, Integer> createChanges() {
        Map<Integer, Integer> changes = new LinkedHashMap<>();
        for (Coin value : Coin.values()) {
            changes.put(value.amount, 0);
        }
        return changes;
    }

    private static List<Integer> createCoinNums() {
        return Arrays.stream(Coin.values()).map(coin -> coin.amount).collect(Collectors.toList());
    }
}
