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

    public void addProduct(Product product) throws DataException {
        if (products.size() < MAX_BASKET_SIZE) {
            products.add(product);
        }
        throw new DataException(String.format("Couldn't add new product. Basket max size is %s.", MAX_BASKET_SIZE));
    }


}
