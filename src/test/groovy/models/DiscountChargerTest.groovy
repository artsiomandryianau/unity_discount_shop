package models

import spock.lang.Specification
import spock.lang.Unroll

import static UtilTest.createValidBasket

class DiscountChargerTest extends Specification {

    @Unroll
    def 'discount charging for #laptopPrice, #headphonesPrice,#keyboardPrice, #mousePrice equal to #laptopDisc, #headphoinesDisc, #keyboardDisc, #mouseDisc'() {

        given:
        Basket basket = createValidBasket(laptopPrice, headphonesPrice, keyboardPrice, mousePrice)
        DiscountCharger discountCharger = new DiscountCharger(basket)

        when:
        def totalDiscount = "500"
        def totalDiscountDouble = 500
        discountCharger.chargeDiscounts(totalDiscount)

        then:
        basket.getProductList().get(0).discount == laptopDisc
        basket.getProductList().get(1).discount == headphoinesDisc
        basket.getProductList().get(2).discount == keyboardDisc
        basket.getProductList().get(3).discount == mouseDisc
        laptopDisc + headphoinesDisc + keyboardDisc + mouseDisc == totalDiscountDouble

        where:
        laptopPrice | headphonesPrice | keyboardPrice | mousePrice | laptopDisc | headphoinesDisc | keyboardDisc | mouseDisc
        "3500"      | "500"           | "500"         | "500"      | 350        | 50              | 50           | 50
        "3500"      | "500"           | "500"         | "499"      | 350        | 50              | 50           | 50
        "5000"      | "10000"         | "500"         | "200"      | 159        | 318             | 15           | 8
        "1500"      | "500"           | "200"         | "300"      | 300        | 100             | 40           | 60
        "1000"      | "100"           | "200"         | "200"      | 333        | 33              | 66           | 68
    }

}
