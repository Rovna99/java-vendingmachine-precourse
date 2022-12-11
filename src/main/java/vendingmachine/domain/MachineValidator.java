package vendingmachine.domain;

public class MachineValidator {
    private static final String MACHINE_MONEY_ERROR_MESSAGE = "금액은 10원 단위로 나누어 떨어져야 하며, 10-10000원 사이입니다.";
    private static final String MACHINE_PRODUCT_ERROR_MESSAGE =
            "상품명은 한글로 작성해주세요. 가격은 10원 단위로 나누어 떨어져야 하며, 100-4000원 사이입니다. 또한, 수량은 99개가 최대입니다.";

    private MachineValidator(){};

    public static void checkMachineMoney(int money) {
        if (money % 10 != 0 || money < 10) {
            throw new IllegalArgumentException(MACHINE_MONEY_ERROR_MESSAGE);
        }
    }

    public static void checkMachineProduct(int price, int amount) {
        if (price % 10 != 0 || price < 100 || amount > 99) {
            throw new IllegalArgumentException(MACHINE_PRODUCT_ERROR_MESSAGE);
        }
    }
}
