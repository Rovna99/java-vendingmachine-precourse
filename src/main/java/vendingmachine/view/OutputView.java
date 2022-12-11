package vendingmachine.view;

public class OutputView {
    private static final String DEFAULT_ERROR_INTRO = "[ERROR] ";


    private OutputView(){

    }

    public static void printRemainMoney() {
    }

    public static void printReturnChange() {

    }

    public static void printError(String message) {
        System.out.println(DEFAULT_ERROR_INTRO + message);
    }
}
