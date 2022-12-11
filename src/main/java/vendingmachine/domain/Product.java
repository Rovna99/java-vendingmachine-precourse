package vendingmachine.domain;

public class Product {
    private final String name;
    private final int price;
    private int amount;

    public Product(String name, String price, String amount) {
        this.name = name;
        this.price = Integer.parseInt(price);
        this.amount = Integer.parseInt(amount);
        MachineValidator.checkMachineProduct(this.price, this.amount);
    }

    public boolean isExhaustion() {
        return amount == 0;
    }

    public int getPrice() {
        return price;
    }

    public boolean isRightProduct(String name) {
        return this.name.equals(name);
    }

    public int chargeProduct() {
        amount--;
        return price;
    }
}
