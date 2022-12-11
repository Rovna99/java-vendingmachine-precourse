package vendingmachine.domain;

public class Product {
    private final String name;
    private final int price;
    private final int amount;

    public Product(String name, String price, String amount) {
        this.name = name;
        this.price = Integer.parseInt(price);
        this.amount = Integer.parseInt(amount);
    }

    public boolean isExhaustion() {
        return amount == 0;
    }

    public int getPrice() {
        return price;
    }
}
