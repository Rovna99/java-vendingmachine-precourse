package vendingmachine.domain;

import java.util.List;

public class Products {
    private static final String NOT_FIND_WANT_PRODUCT = "현재 판매하지 않는 제품입니다.";
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

    public int sell(String productName) {
        for (Product product : products) {
            if (product.isRightProduct(productName)) {
                return product.chargeProduct();
            }
        }
        throw new IllegalArgumentException(NOT_FIND_WANT_PRODUCT);
    }
}
