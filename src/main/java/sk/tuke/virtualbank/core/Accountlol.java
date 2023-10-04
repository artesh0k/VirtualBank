package sk.tuke.virtualbank.core;

public class Accountlol {

    private String cardNumber;
    private double money;

    public Accountlol(String cardNumber, double money) {
        this.cardNumber = cardNumber;
        this.money = money;
    }

    public boolean Pay(double price){
        if(money < price || price < 0)
            return false;

        money-=price;
        return true;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public double getMoney() {
        return money;
    }
}
