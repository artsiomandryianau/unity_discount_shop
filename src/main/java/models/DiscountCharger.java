package models;

import exceptions.DataException;

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

        int discount = parsePrice(totalDiscount);
        distributeDiscounts(discount);

    }

    private void distributeDiscounts(int totalDiscount) {
        int totalBasketPrice = basket.getTotalPrice();
        for (Product product : basket.getProductList()) {
            if (isLastProductInBasket(product, basket)) {
                product.setDiscount(totalDiscount - getCurrentDiscount());
                continue;
            }
            int currentDiscount = (product.getInitialPrice() * totalDiscount) / totalBasketPrice;
            product.setDiscount(currentDiscount);
        }
    }

    private int getCurrentDiscount() {
        return basket.getProductList().stream()
                .mapToInt(Product::getDiscount)
                .sum();
    }

    private static boolean isLastProductInBasket(Product product, Basket basket) {
        return product.equals(basket.getProductList().get(basket.getProductList().size() - 1));
    }


}
