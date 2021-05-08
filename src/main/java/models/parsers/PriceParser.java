package models.parsers;

import com.google.common.base.Strings;
import exceptions.DataException;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import static configuration.Configuration.DECIMAL_PLACES;

public class PriceParser {

    public static double parsePrice(String price) throws DataException {
        if (Strings.isNullOrEmpty(price)) {
            throw new DataException("Value shouldn't be null or empty");
        }
        if (!NumberUtils.isNumber(price)) {
            throw new DataException(String.format("Value %s is not a number", price));
        }
        if (toLongDecimalPart(price)) {
            throw new DataException(String.format("Value %s has too long decimal part. Should be not longer then %s", price, DECIMAL_PLACES));
        }
        double priceOfProduct = Double.parseDouble(price);
        if (priceOfProduct >= 0) {
            return priceOfProduct;
        }
        throw new DataException("Price couldn't be less or equal to zero");
    }

    private static boolean toLongDecimalPart(String totalDiscount) {
        if (totalDiscount.contains("."))
            return totalDiscount.substring(totalDiscount.indexOf(".") + 1).length() > DECIMAL_PLACES;
        return false;
    }
}
