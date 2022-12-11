package vendingmachine.controller;

import java.util.Map;
import java.util.function.Supplier;
import vendingmachine.domain.Coin;
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
            OutputView.printRemainMoney(service.getRemainMoney());
            String sellName = "";
            service.sellProduct(sellName);
        }
    }

    private void returnChange() {
        int remainMoney = service.getRemainMoney();
        OutputView.printRemainMoney(remainMoney);
        Map<Integer, Integer> remainChanges = Coin.moneyToChange(remainMoney);
        OutputView.printReturnChange(remainChanges);
    }
}
