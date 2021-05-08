package models


import spock.lang.Specification
import spock.lang.Unroll

class ProductFactoryTest extends Specification {

    @Unroll
    def 'should parse String value #price to double and round it'() {

        given:
        ProductFactory productFactory = new ProductFactory()
        def product = productFactory.createProduct(name, price)

        when:
        def priceOfProduct = product.getPrice()

        then:
        priceOfProduct == expectedPrice

        where:
        name   | price       | expectedPrice
        "Prod" | "1000.0026" | 1000.00
        "Prod" | "1011.089"  | 1011.09
        "Prod" | "1022.0085" | 1022.01
        "Prod" | "1000.0842" | 1000.08
        "Prod" | "1000.0852" | 1000.09
    }
}
