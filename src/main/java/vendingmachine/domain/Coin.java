package vendingmachine.domain;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

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
        Map<Integer, Integer> changes = new LinkedHashMap<>();
        for (Coin value : Coin.values()) {
            changes.put(value.amount, money / value.amount);
            money %= value.amount;
        }
        return changes;
    }
}
