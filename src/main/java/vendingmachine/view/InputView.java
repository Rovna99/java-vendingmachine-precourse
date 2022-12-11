package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class InputView {
    private static final Pattern NUMBER_REGEX = Pattern.compile("\\d+");
    private static final Pattern KOREAN_REGEX = Pattern.compile("[가-힇]+");
    private static final String INPUT_MACHINE_MONEY_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    private static final String INPUT_MACHINE_MONEY_ERROR_MESSAGE = "자판기 보유 금액은 자연수여야 합니다.";
    private static final String INPUT_PRODUCT_DETAILS_MESSAGE = "상품명과 가격, 수량을 입력해 주세요.";
    private static final String INPUT_PRODUCT_DETAILS_ERROR_MESSAGE = "상품명은 한글이어야 하며, 가격, 수량은 자연수여야 합니다."
                    + "\n상품명, 가격, 수량을 쉼표로, 개별 상품을 대괄호([])로 묶어 세미콜론(;)으로 구분해주세요"
            + "\n예시: [콜라,1500,20];[사이다,1000,10]";
    private static final String INPUT_USER_MONEY_MESSAGE = "투입 금액을 입력해 주세요.";
    private static final String INPUT_USER_MONEY_ERROR_MESSAGE = "투입 금액은 자연수여야 합니다.";
    private static final String INPUT_WANT_PRODUCT_MESSAGE = "구매할 상품명을 입력해 주세요.";
    private static final String INPUT_WANT_PRODUCT_ERROR_MESSAGE = "구매할 상품명은 한글이어야 합니다.";

    private InputView(){}

    public static String inputMachineMoney() {
        System.out.println(INPUT_MACHINE_MONEY_MESSAGE);
        String input = Console.readLine();
        System.out.println();
        validateMachineMoney(input);
        return input;
    }

    private static void validateMachineMoney(String input) {
        if (!NUMBER_REGEX.matcher(input).matches()) {
            throw new IllegalArgumentException(INPUT_MACHINE_MONEY_ERROR_MESSAGE);
        }
    }

    public static String inputProductDetails() {
        System.out.println(INPUT_PRODUCT_DETAILS_MESSAGE);
        String input = Console.readLine();
        System.out.println();
        validateProductDetails(input);
        return input;
    }

    private static void validateProductDetails(String input) {
        if (input.length() >= 3) {
            checkDetails(input);
            return;
        }
        throw new IllegalArgumentException(INPUT_PRODUCT_DETAILS_ERROR_MESSAGE);
    }

    private static void checkDetails(String input) {
        for (String product : input.split(";")) {
            product = product.substring(1, product.length()-1);
            List<String> details = Arrays.asList(product.split(","));
            if (!KOREAN_REGEX.matcher(details.get(0)).matches() || !NUMBER_REGEX.matcher(details.get(1)).matches() ||
                    !NUMBER_REGEX.matcher(details.get(2)).matches()) {
                throw new IllegalArgumentException(INPUT_PRODUCT_DETAILS_ERROR_MESSAGE);
            }
        }
    }

    public static String inputUserMoney() {
        System.out.println(INPUT_USER_MONEY_MESSAGE);
        String input = Console.readLine();
        validateUserMoney(input);
        return input;
    }

    private static void validateUserMoney(String input) {
        if (!NUMBER_REGEX.matcher(input).matches()) {
            throw new IllegalArgumentException(INPUT_USER_MONEY_ERROR_MESSAGE);
        }
    }

    public static String inputWantProduct() {
        System.out.println(INPUT_WANT_PRODUCT_MESSAGE);
        String input = Console.readLine();
        validateWantProduct(input);
        return input;
    }

    private static void validateWantProduct(String input) {
        if (!KOREAN_REGEX.matcher(input).matches()) {
            throw new IllegalArgumentException(INPUT_WANT_PRODUCT_ERROR_MESSAGE);
        }
    }
}
