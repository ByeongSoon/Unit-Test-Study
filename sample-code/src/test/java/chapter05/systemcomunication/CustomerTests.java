package chapter05.systemcomunication;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class CustomerTests {

    @Test
    @DisplayName("취약한 테스트로 이어지는 목 사용")
    public void purchaseSucceedsWhenEnoughInventory() throws Exception {
        IStore storeMock = mock(IStore.class);
        when(storeMock.hasEnoughInventory(Product.Shampoo, 5)).thenReturn(true);
        Customer customer = new Customer();

        boolean success = customer.purchase(storeMock, Product.Shampoo, 5);

        Assertions.assertTrue(success);
        verify(storeMock, times(1)).removeInventory(Product.Shampoo, 5);
    }

    @Test
    @DisplayName("목을 사용하지 않은 테스트")
    public void afterPurchaseSucceedsWhenEnoughInventory() throws Exception {
        IStore store = new Store();
        store.addInventory(Product.Shampoo, 10);
        Customer sut = new Customer();

        sut.purchase(store, Product.Shampoo, 5);

        Assertions.assertEquals(5, store.getInventory(Product.Shampoo));
    }

}
