package vendingmachine.domain;

import java.util.Map;

public class VendingMachine {
    private final MachineState state;

    public VendingMachine() {
        this.state = new MachineState();
    }

    public void setMachineMoney(int money) {
        MachineValidator.checkMachineMoney(money);
        state.saveChanges(Coin.moneyToChange(money));
    }

    public Map<Integer, Integer> getChanges() {
        return state.getChanges();
    }

    public void setProduct() {

    }

    public void sellProduct() {

    }

    public void returnChange() {

    }
}
