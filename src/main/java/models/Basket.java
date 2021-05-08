package models;

import exceptions.DataException;

import java.util.ArrayList;
import java.util.List;

import static configuration.Configuration.MAX_BASKET_SIZE;


public class Basket {

    private List<Product> products;

    public Basket() {
        products = new ArrayList<>();
    }

    public double getTotalPrice() {
        return products.stream()
                .mapToDouble(Product::getInitialPrice)
                .sum();
    }

    public void addProduct(Product product) throws DataException {
        if (product == null) {
            throw new DataException("Product shouldn't be equal to zero");
        }
        if (products.size() < MAX_BASKET_SIZE) {
            products.add(product);
        } else {
            throw new DataException(String.format("Couldn't add new product. Basket max size is %s.", MAX_BASKET_SIZE));
        }
    }

    public int size() {
        return products.size();
    }

    public List<Product> getProductList() {
        return products;
    }

}
