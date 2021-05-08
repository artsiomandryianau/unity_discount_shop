package models;

public class Product {

    private String name;
    private int initialPrice;
    private int discount;

    public Product(String name, int initialPrice) {
        this.name = name;
        this.initialPrice = initialPrice;
        discount = 0;
    }

    @Override
    public String toString() {
        return name + '\'' +
                ", initialPrice: " + initialPrice +
                ", discount: " + discount;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getInitialPrice() {
        return initialPrice;
    }

    public void setInitialPrice(int initialPrice) {
        this.initialPrice = initialPrice;
    }
}
