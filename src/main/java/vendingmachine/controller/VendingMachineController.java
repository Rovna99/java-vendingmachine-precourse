package vendingmachine.controller;

import vendingmachine.service.VendingMachineService;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {
    private final VendingMachineService service;

    public VendingMachineController() {
        service = new VendingMachineService();
    }

    public void run() {
        setMachineMoney();
        setMachineProduct();
        setNewCustomer();
        startSellProduct();
        returnChange();
    }

    private void setMachineMoney() {
        try {
            int inputMoney = Integer.parseInt(InputView.inputMachineMoney());
            service.setVendingMachineMoney(inputMoney);
            OutputView.printChangeAmount(service.getChangeAmount());
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            setMachineMoney();
        }
    }

    private void setMachineProduct() {
        try {
            String inputDetails = InputView.inputProductDetails();
            service.setProduct(inputDetails);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            setMachineProduct();
        }
    }

    private void setNewCustomer() {
        try {
            int inputUserMoney = Integer.parseInt(InputView.inputUserMoney());
            service.comeNewCustomer(inputUserMoney);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            setNewCustomer();
        }
    }

    private void startSellProduct() {
        while (!service.isSellEnd()) {
            try {
                OutputView.printRemainMoney(service.getRemainMoney());
                String sellName = InputView.inputWantProduct();
                service.sellProduct(sellName);
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }

    private void returnChange() {
        int remainMoney = service.getRemainMoney();
        OutputView.printRemainMoney(remainMoney);
        OutputView.printReturnChange(service.returnChange());
    }
}
