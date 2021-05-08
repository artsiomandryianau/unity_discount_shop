package models;

import exceptions.DataException;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static configuration.Configuration.DECIMAL_PLACES;
import static models.parsers.PriceParser.parsePrice;

public class DiscountCharger {

    private final Basket basket;

    public DiscountCharger(Basket basket) {
        this.basket = basket;
    }

    public void chargeDiscounts(String totalDiscount) throws DataException {
        if (basket.size() == 0) {
            throw new DataException("Basket shouldn't be empty");
        }

        double discount = parsePrice(totalDiscount);
        distributeDiscounts(discount);

    }

    private void distributeDiscounts(double totalDiscount) {
        double totalBasketPrice = basket.getTotalPrice();
        for (Product product : basket.getProductList()) {
            if (isLastProductInBasket(product, basket)) {
                product.setDiscount(totalDiscount - getCurrentDiscount());
                continue;
            }
            double currentDiscount = new BigDecimal((product.getInitialPrice() / totalBasketPrice) * totalDiscount)
                    .setScale(DECIMAL_PLACES, RoundingMode.FLOOR).doubleValue();
            product.setDiscount(currentDiscount);
        }
    }

    private double getCurrentDiscount() {
        return basket.getProductList().stream()
                .mapToDouble(Product::getDiscount)
                .sum();
    }

    private static boolean isLastProductInBasket(Product product, Basket basket) {
        return product.equals(basket.getProductList().get(basket.getProductList().size() - 1));
    }


}
