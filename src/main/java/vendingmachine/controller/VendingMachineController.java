package vendingmachine.controller;

import java.util.Map;
import java.util.function.Supplier;
import vendingmachine.domain.Coin;
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

    private void startSellProduct() {
        try {
            int inputUserMoney = Integer.parseInt(InputView.inputUserMoney());
            service.comeNewCustomer(inputUserMoney);
            sellProduct();
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            startSellProduct();
        }
    }

    private void sellProduct() {
        while (!service.isSellEnd()) {
            OutputView.printRemainMoney(service.getRemainMoney());
            String sellName = InputView.inputWantProduct();
            service.sellProduct(sellName);
        }
    }

    private void returnChange() {
        int remainMoney = service.getRemainMoney();
        OutputView.printRemainMoney(remainMoney);
        OutputView.printReturnChange(service.returnChange());
    }
}
