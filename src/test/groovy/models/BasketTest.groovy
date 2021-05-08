package models

import exceptions.DataException
import spock.lang.Specification

import static UtilTest.createValidBasket
import static UtilTest.productFactory

class BasketTest extends Specification {

    def 'should add new product to basket'() {

        given:
        def basket = new Basket()

        when:
        basket.addProduct(productFactory.createProduct("Webcam", "100"))

        then:
        basket.size() > 0
    }

    def 'should throw Data exception if put more products to basket than allowed'() {

        given:
        def basket = createValidBasket("3500", "2020", "10", "300")
        basket.addProduct(productFactory.createProduct("Charger", "10"))

        when:
        basket.addProduct(productFactory.createProduct("Webcam", "100"))

        then:
        thrown(DataException)
    }
}
