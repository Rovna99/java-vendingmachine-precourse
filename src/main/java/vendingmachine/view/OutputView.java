package vendingmachine.view;

import java.util.Map;
import java.util.Map.Entry;

public class OutputView {
    private static final String DEFAULT_ERROR_INTRO = "[ERROR] ";
    private static final String CHANGES_DELIMITER = " - ";
    private static final String PRINT_REMAIN_MONEY = "투입금액: %s원%n";


    private OutputView(){

    }

    public static void printChangeAmount(Map<Integer, Integer> changes) {
        for (Entry<Integer, Integer> e : changes.entrySet()) {
            String money = e.getKey() + "원";
            String amount = e.getValue() + "개";
            System.out.println(String.join(CHANGES_DELIMITER, money, amount));
        }
    }

    public static void printRemainMoney(int money) {
        System.out.printf(PRINT_REMAIN_MONEY, money);
    }

    public static void printReturnChange() {

    }

    public static void printError(String message) {
        System.out.println(DEFAULT_ERROR_INTRO + message);
    }
}
