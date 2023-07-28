package test;

import com.jobhacker.Product;
import com.jobhacker.ShoppingCart;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {
    @Test
    void shouldCalculateAllPrices() throws IOException {
        ShoppingCart calc = new ShoppingCart();
        Product product = new Product();
        product.setName("good1");
        product.setPrice(1200.00);
        Product product1 = new Product();
        product1.setName("good1");
        product1.setPrice(1000.00);
        Product product2 = new Product();
        product2.setName("good1");
        product2.setPrice(800.00);
        calc.addProduct(product);
        calc.addProduct(product1);
        calc.addProduct(product2);
        calc.removeProduct(product1);
        assertEquals(2000.00,calc.calculateTotalCost());
    }
}