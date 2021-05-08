package models.parsers

import exceptions.DataException
import spock.lang.Specification
import spock.lang.Unroll

class PriceParserTest extends Specification {

    @Unroll
    def 'should parse String value #price to double #expectedPrice'() {

        given:
        def parser = new PriceParser()

        when:
        def priceOfProduct = parser.parsePrice(price)

        then:
        priceOfProduct == expectedPrice

        where:
        price     | expectedPrice
        "1011.08" | 1011.08
        "1022"    | 1022.0
        "1000.01" | 1000.01
    }

    def 'should throw Data exception if parser get wrong value #value'() {

        given:
        def parser = new PriceParser()

        when:
        parser.parsePrice(price)

        then:
        thrown(DataException)

        where:
        price << ["1230.2131", "dsf", "", "sdf1.123"]
    }
}
