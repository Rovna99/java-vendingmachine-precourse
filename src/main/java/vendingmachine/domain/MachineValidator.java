package vendingmachine.domain;

public class MachineValidator {
    private static final String MACHINE_MONEY_ERROR_MESSAGE = "금액은 10원 단위로 나누어 떨어져야 하며, 10-1000000원 사이입니다.";
    private static final String MACHINE_PRODUCT_ERROR_MESSAGE =
            "가격은 10원 단위로 나누어 떨어져야 하며, 100-4000원 사이입니다. 또한, 수량은 99개가 최대입니다.";
    private static final String USER_MONEY_ERROR_MESSAGE = "금액은 10원 단위로 나누어 떨어져야 하며, 100-50000원 사이입니다.";

    private MachineValidator() {
    }

    public static void checkMachineMoney(int money) {
        if (money % 10 != 0 || money < 10 || money > 1000000) {
            throw new IllegalArgumentException(MACHINE_MONEY_ERROR_MESSAGE);
        }
    }

    public static void checkMachineProduct(int price, int amount) {
        if (price % 10 != 0 || price < 100 || amount > 99 || amount <= 0) {
            throw new IllegalArgumentException(MACHINE_PRODUCT_ERROR_MESSAGE);
        }
    }

    public static void checkUserMoney(int money) {
        if (money % 10 != 0 || money < 100 || money > 50000) {
            throw new IllegalArgumentException(USER_MONEY_ERROR_MESSAGE);
        }
    }
}
