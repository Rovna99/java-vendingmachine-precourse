package vendingmachine.domain;

import java.util.ArrayList;
import java.util.List;

public class Products {
    private final List<Product> products;

    public Products(List<Product> product) {
        this.products = product;
    }

    public boolean isProductZero() {
        for (Product product : products) {
            if (product.isExhaustion()) {
                return true;
            }
        }
        return false;
    }

    public int findMinimumPrice() {
        int minimum = 1000000;
        for (Product product : products) {
            minimum = Math.min(product.getPrice(), minimum);
        }
        return minimum;
    }
}
