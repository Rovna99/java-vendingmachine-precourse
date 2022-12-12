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
            product = product.substring(1, product.length()-1);
            List<String> productDetail = Arrays.asList(product.split(","));
            products.add(new Product(productDetail.get(0), productDetail.get(1), productDetail.get(2)));
        }
        state.setProducts(products);
    }

    public boolean isEnd() {
        return state.endSell();
    }

    public int getMinimumPrice() {
        return state.checkMinimumPrice();
    }

    public int sellProduct(String productName) {
        return state.sellUserWantProduct(productName);
    }

    public Map<Integer, Integer> returnChange(int userRemainMoney) {
        return state.returnChange(userRemainMoney);
    }
}
