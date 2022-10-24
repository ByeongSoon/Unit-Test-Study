package chapter05.systemcomunication;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class CustomerControllerTests {

    @Test
    @DisplayName("취약한 테스트로 이어지지 않는 목 사용")
    public void successfulPurchase() throws Exception {
        IEmailGateway mock = mock(IEmailGateway.class);
        CustomerController sut = new CustomerController(mock);

        boolean isSuccess = sut.purchase(1,2,5);

        Assertions.assertTrue(isSuccess);
        verify(mock, times(1))
            .sendReceipt(
            "customer@email.com",
            "Shampoo",
            5);
    }

}
