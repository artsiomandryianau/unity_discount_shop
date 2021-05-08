import com.google.common.collect.ImmutableList
import models.Basket
import models.Product
import models.ProductFactory
import spock.lang.Specification

class UtilTest extends Specification {

    static ProductFactory productFactory = new ProductFactory()

    static createValidBasket(laptopPrice, headphonesPrice, keyboardPrice, mousePrice) {
        List<Product> productList = new ImmutableList.Builder<Product>()
                .add(productFactory.createProduct("Laptop", laptopPrice))
                .add(productFactory.createProduct("Headphones", headphonesPrice))
                .add(productFactory.createProduct("Keyboard", keyboardPrice))
                .add(productFactory.createProduct("Mouse", mousePrice))
                .build()

        Basket basket = new Basket()
        productList.stream()
                .forEach({ e -> basket.addProduct(e) })
        return basket
    }
}
