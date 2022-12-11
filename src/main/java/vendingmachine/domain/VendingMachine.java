package vendingmachine.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

    public void setProduct(String details) {
        List<Product> products = new ArrayList<>();
        for (String product : details.split(";")) {
            List<String> productDetail = Arrays.asList(product.split(","));
            products.add(new Product(productDetail.get(0), productDetail.get(1), productDetail.get(2)));
        }
        state.setProducts(products);
    }

    public void sellProduct() {

    }

    public void returnChange() {

    }
}
