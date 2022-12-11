package vendingmachine.domain;

import java.util.ArrayList;
import java.util.List;

public class Products {
    private final List<Product> products;

    public Products(List<String> product) {
        this.products = saveProduct(product);
    }

    private List<Product> saveProduct(List<String> product) {
        return new ArrayList<>();
    }
}
