package vendingmachine.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MachineState {
    private Map<Integer, Integer> changes;
    private Products products;

    public void saveChanges(Map<Integer, Integer> changes) {
        this.changes = changes;
    }

    public Map<Integer, Integer> getChanges() {
        return changes;
    }

    public void setProducts(List<Product> products) {
        this.products = new Products(products);
    }

    public boolean endSell() {
        return products.isProductZero();
    }

    public int checkMinimumPrice() {
        return products.findMinimumPrice();
    }

    public int sellUserWantProduct(String productName) {
        return products.sell(productName);
    }

    public Map<Integer, Integer> returnChange(int userRemainMoney) {
        Map<Integer, Integer> returnChanges = new LinkedHashMap<>();
        for (Entry<Integer, Integer> e : changes.entrySet()) {
            userRemainMoney = countCoins(e, returnChanges, userRemainMoney);
        }
        return returnChanges;
    }

    private int countCoins(Entry<Integer, Integer> e, Map<Integer, Integer> returnChanges, int userRemainMoney) {
        int money = 0;
        int count;
        for (count = 0; count < e.getValue(); count++) {
            money += e.getKey();
            if (userRemainMoney - money < 0) {
                break;
            }
        }
        returnChanges.put(e.getKey(), count);
        return userRemainMoney - money;
    }
}
