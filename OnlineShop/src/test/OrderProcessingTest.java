package test;

import com.jobhacker.OrderProcessing;
import com.jobhacker.Product;
import com.jobhacker.ShoppingCart;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class OrderProcessingTest {

    @Test
    void checkPlaceHolder(){
        Product product = new Product();
        product.setName("good1");
        product.setPrice(1400.00);
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(product);

        OrderProcessing order = new OrderProcessing();
        order.placeHolder(cart);
    }
}