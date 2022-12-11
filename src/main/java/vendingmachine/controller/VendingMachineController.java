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
        try {
            String inputDetails = "";
            service.setProduct(inputDetails);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            setMachineMoney();
        }
    }

    private void startSellProduct() {
        try {
            int inputUserMoney = 0;
            service.comeNewCustomer(inputUserMoney);
            sellProduct();
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            setMachineMoney();
        }
    }

    private void sellProduct() {
        while (service.isSellEnd()) {
            String sellName = "";
            service.sellProduct(sellName);
            OutputView.printRemainMoney(service.getRemainMoney());
        }
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
