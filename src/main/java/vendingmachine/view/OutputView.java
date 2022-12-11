package vendingmachine.view;

import java.util.Map;
import java.util.Map.Entry;

public class OutputView {
    private static final String DEFAULT_ERROR_INTRO = "[ERROR] ";
    private static final String CHANGES_DELIMITER = " - ";
    private static final String PRINT_REMAIN_MONEY = "\n투입 금액: %s원%n";


    private OutputView() {

    }

    public static void printChangeAmount(Map<Integer, Integer> changes) {
        System.out.println("자판기가 보유한 동전");
        for (Entry<Integer, Integer> e : changes.entrySet()) {
            String money = e.getKey() + "원";
            String amount = e.getValue() + "개";
            System.out.println(String.join(CHANGES_DELIMITER, money, amount));
        }
    }

    public static void printRemainMoney(int money) {
        System.out.printf(PRINT_REMAIN_MONEY, money);
    }

    public static void printReturnChange(Map<Integer, Integer> changes) {
        System.out.println("잔돈");
        for (Entry<Integer, Integer> e : changes.entrySet()) {
            if (e.getValue() != 0) {
                String money = e.getKey() + "원";
                String amount = e.getValue() + "개";
                System.out.println(String.join(CHANGES_DELIMITER, money, amount));
            }
        }
    }

    public static void printError(String message) {
        System.out.println(DEFAULT_ERROR_INTRO + message);
    }
}
