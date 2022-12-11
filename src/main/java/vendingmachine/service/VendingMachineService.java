package vendingmachine.service;

import java.util.Map;
import vendingmachine.domain.User;
import vendingmachine.domain.VendingMachine;

public class VendingMachineService {
    private final VendingMachine machine;
    private User user;

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
        machine.setProduct(productDetails);
    }

    public void comeNewCustomer(int money) {
        user = new User(money);
    }

    public boolean isSellEnd() {
        return (machine.isEnd() || user.isMoneyScarce(machine.getMinimumPrice()));
    }

    public void sellProduct(String productName) {
    }

    public void returnChange() {

    }
}
