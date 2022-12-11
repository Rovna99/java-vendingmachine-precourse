package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class InputView {
    private static final Pattern NUMBER_REGEX = Pattern.compile("\\d+");
    private static final String INPUT_MACHINE_MONEY_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    private static final String INPUT_MACHINE_MONEY_ERROR_MESSAGE = "자판기 보유 금액은 자연수여야 합니다.";

    private InputView(){}

    public static String inputMachineMoney() {
        System.out.println(INPUT_MACHINE_MONEY_MESSAGE);
        String input = Console.readLine();
        validateMachineMoney(input);
        return input;
    }

    private static void validateMachineMoney(String input) {
        if (!NUMBER_REGEX.matcher(input).matches()) {
            throw new IllegalArgumentException(INPUT_MACHINE_MONEY_ERROR_MESSAGE);
        }
    }
}
