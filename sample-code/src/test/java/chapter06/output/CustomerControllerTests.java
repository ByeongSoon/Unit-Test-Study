package chapter06.output;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerControllerTests {

    @Test
    @DisplayName("예제 6.1 출력 기반 테스트")
    public void discountOfTwoProducts() {
        Product product1 = new Product("Hand Wash");
        Product product2 = new Product("Shampoo");
        Product[] products = {product1, product2};
        PriceEngine sut = new PriceEngine();

        double discount = sut.calculateDiscount(products);

        assertEquals(0.02, discount);
    }

}
