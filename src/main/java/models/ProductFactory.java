package models;

import com.google.common.base.Strings;
import exceptions.DataException;

import static models.parsers.PriceParser.parsePrice;


public class ProductFactory {

    public Product createProduct(String name, String price) throws DataException {
        if (Strings.isNullOrEmpty(name)) {
            throw new DataException("Name of product shouldn't be null or empty");
        }
        if (Strings.isNullOrEmpty(price)) {
            throw new DataException("Price of product shouldn't be null or empty");
        }

        double priceOfProduct = parsePrice(price);

        if (!(priceOfProduct == 0)) {
            return new Product(name, priceOfProduct);
        }
        throw new DataException("Price of product couldn't be equal to zero");
    }

}
