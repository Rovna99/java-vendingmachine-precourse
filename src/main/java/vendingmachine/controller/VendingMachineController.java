package vendingmachine.controller;

import java.util.function.Supplier;
import vendingmachine.service.VendingMachineService;
import vendingmachine.view.OutputView;

public class VendingMachineController {
    private final VendingMachineService service;

    public VendingMachineController() {
        service = new VendingMachineService();
    }

    public void run() {
        setMachineMoney();
        setMachineProduct();
        startSellProduct();
        returnChange();
    }

    private void setMachineMoney() {
        try {
            int inputMoney = 0;
            service.setVendingMachineMoney(inputMoney);
            OutputView.printChangeAmount(service.getChangeAmount());
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            setMachineMoney();
        }
    }

    private void setMachineProduct() {
    }

    private void startSellProduct() {
    }

    private void returnChange() {
    }

    private <T> T repeat(Supplier<T> inputReader) {
        try {
            return inputReader.get();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return repeat(inputReader);
        }
    }
}
