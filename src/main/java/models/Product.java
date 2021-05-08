package models;

public class Product {

    private String name;
    private double initialPrice;
    private double discount;

    public Product(String name, double initialPrice) {
        this.name = name;
        this.initialPrice = initialPrice;
        discount = 0d;
    }

    @Override
    public String toString() {
        return name + '\'' +
                ", initialPrice: " + initialPrice +
                ", discount: " + discount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getInitialPrice() {
        return initialPrice;
    }

    public void setInitialPrice(double initialPrice) {
        this.initialPrice = initialPrice;
    }
}
