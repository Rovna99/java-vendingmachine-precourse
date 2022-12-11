package vendingmachine.domain;

public class User {
    private int userMoney;

    public User(int money) {
        userMoney = money;
    }

    public void subtractPrice(int charge) {
        userMoney -= charge;
    }

    public boolean isMoneyScarce(int minimumPrice) {
        return userMoney < minimumPrice;
    }
}
