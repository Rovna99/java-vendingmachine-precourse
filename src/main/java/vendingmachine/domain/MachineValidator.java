package vendingmachine.domain;

public class MachineValidator {
    private static final String MACHINE_MONEY_ERROR_MESSAGE = "자판기 보유 금액은 10원 단위로 나누어 떨어져야 하며, 10원 이상입니다.";

    private MachineValidator(){};

    public static void checkMachineMoney(int money) {
        if (money % 10 != 0 || money < 10) {
            throw new IllegalArgumentException(MACHINE_MONEY_ERROR_MESSAGE);
        }
    }
}
