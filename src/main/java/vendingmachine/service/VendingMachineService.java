package vendingmachine.service;

import java.util.LinkedHashMap;
import java.util.Map;
import vendingmachine.domain.VendingMachine;

public class VendingMachineService {
    private final VendingMachine machine;

    public VendingMachineService() {
        machine = new VendingMachine();
    }

    public void setVendingMachineMoney(int userMoney) {
        machine.setMachineMoney(userMoney);
    }

    public Map<Integer, Integer> getChangeAmount() {
        return machine.getChanges();
    }

    public void setProduct(String productDetails) {

    }

    public void sellProduct(String productName) {

    }

    public void returnChange() {

    }
}
