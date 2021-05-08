package models.parsers;

import com.google.common.base.Strings;
import exceptions.DataException;
import org.apache.commons.lang3.math.NumberUtils;

public class PriceParser {

    public static int parsePrice(String price) throws DataException {
        if (Strings.isNullOrEmpty(price)) {
            throw new DataException("Value shouldn't be null or empty");
        }
        if (!NumberUtils.isNumber(price)) {
            throw new DataException(String.format("Value %s is not a number", price));
        }
        if (hasDecimalPart(price)) {
            throw new DataException("Value %s has decimal part");
        }
        int priceOfProduct = Integer.parseInt(price);
        if (priceOfProduct >= 0) {
            return priceOfProduct;
        }
        throw new DataException("Price couldn't be less or equal to zero");
    }

    private static boolean hasDecimalPart(String totalDiscount) {
        return totalDiscount.contains(".");
    }
}
