package models;

import com.google.common.base.Strings;
import exceptions.DataException;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static configuration.Configuration.DECIMAL_PLACES;

public class ProductFactory {

    public Product createProduct(String name, String price) throws DataException {
        if (Strings.isNullOrEmpty(name)) {
            throw new DataException("Name of product shouldn't be null or empty");
        }
        if (Strings.isNullOrEmpty(price)) {
            throw new DataException("Price of product shouldn't be null or empty");
        }

        Double priceOfProduct = parseOrNull(price);

        if (priceOfProduct != null) {
            return new Product(name, priceOfProduct);
        }
        return null;
    }

    private static Double parseOrNull(String price) throws DataException {
        Double priceDouble = null;
        try {
            priceDouble = new BigDecimal(price).setScale(DECIMAL_PLACES, RoundingMode.HALF_UP).doubleValue();
        } catch (NumberFormatException e) {
            throw new DataException("Price value is not valid");
        }
        return priceDouble;
    }
}
