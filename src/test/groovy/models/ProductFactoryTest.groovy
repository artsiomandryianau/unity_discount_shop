package models

import exceptions.DataException
import spock.lang.Specification
import spock.lang.Unroll

class ProductFactoryTest extends Specification {

    ProductFactory productFactory = new ProductFactory()

    @Unroll
    def 'should parse String value #price to double and round it to #expectedPrice'() {

        given:
        def product = productFactory.createProduct(name, price)

        when:
        def priceOfProduct = product.getInitialPrice()

        then:
        priceOfProduct == expectedPrice

        where:
        name   | price  | expectedPrice
        "Prod" | "1011" | 1011
        "Prod" | "1022" | 1022
    }

    @Unroll
    def 'should throw exception when name = #name or price = #price values are not valid'() {
        when:
        productFactory.createProduct(name, price)

        then:
        thrown(DataException)

        where:
        name   | price
        ""     | "1000.0026"
        "Prod" | "1000.0026"
        null   | "1011.089"
        "Prod" | "1qqer022.0085"
        "Prod" | "-1000.08"
        "Prod" | "0.0"
    }
}
