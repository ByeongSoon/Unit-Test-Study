package chapter06.state;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerControllerTests {

    @Test
    @DisplayName("예제 6.2 상태 기반 테스트")
    public void addingAProductToAnOrder() {
        Product product = new Product("Hand Wash");
        Order sut = new Order();

        sut.addProduct(product);

        assertEquals(1, sut.products.size());
        assertEquals(product, sut.products.get(0));
    }

}
