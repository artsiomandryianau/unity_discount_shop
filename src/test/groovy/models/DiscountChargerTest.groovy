package models

import spock.lang.Specification
import spock.lang.Unroll

import static UtilTest.createValidBasket

class DiscountChargerTest extends Specification {

    @Unroll
    def 'discount charging for laptop (price = #laptopPrice) equals to #laptopDisc'() {

        given:
        Basket basket = createValidBasket(laptopPrice, headphonesPrice, keyboardPrice, mousePrice)
        DiscountCharger discountCharger = new DiscountCharger(basket)

        when:
        def totalDiscount = "500.00"
        def totalDiscountDouble = 500.00d
        discountCharger.chargeDiscounts(totalDiscount)

        then:
        basket.getProductList().get(0).discount == laptopDisc
        basket.getProductList().get(1).discount == headphoinesDisc
        basket.getProductList().get(2).discount == keyboardDisc
        basket.getProductList().get(3).discount == mouseDisc
        laptopDisc + headphoinesDisc + keyboardDisc + mouseDisc == totalDiscountDouble

        where:
        laptopPrice | headphonesPrice | keyboardPrice | mousePrice | laptopDisc | headphoinesDisc | keyboardDisc | mouseDisc
        "3500.00"   | "500.00"        | "500.00"      | "500.00"   | 350.00     | 50.00           | 50.00        | 50.00
        "3500.00"   | "500.00"        | "500.00"      | "499.99"   | 350.00     | 50.00           | 50.00        | 50.00
        "3500.00"   | "500.00"        | "500.00"      | "499.96"   | 350.00     | 50.00           | 50.00        | 50.00
        "1500.00"   | "500.00"        | "200.00"      | "300.00"   | 300.00     | 100.00          | 40.00        | 60.00
        "1000.00"   | "100.00"        | "200.00"      | "200.00"   | 333.33     | 33.33           | 66.66        | 66.68
    }

}
