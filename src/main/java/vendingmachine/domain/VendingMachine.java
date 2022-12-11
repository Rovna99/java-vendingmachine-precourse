package vendingmachine.domain;

public class VendingMachine {
    private final MachineState state;

    public VendingMachine() {
        this.state = new MachineState();
    }

    public void setMachineMoney(int money) {
        MachineValidator.checkMachineMoney(money);
        state.saveChanges(Coin.moneyToChange(money));
    }

    public void setProduct() {

    }

    public void sellProduct() {

    }

    public void returnChange() {

    }
}
