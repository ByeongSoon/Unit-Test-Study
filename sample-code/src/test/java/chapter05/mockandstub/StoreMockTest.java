package chapter05.mockandstub;

import chapter02.IStore;
import chapter02.LondonCustomer;
import chapter02.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class StoreMockTest {

    /*
    * 두 가지 목적으로 storeMock을 사용한다.

    * 준비된 응답을 반환
    * SUT에서 수행한 메서드 호출을 검증
     */

    @Test
    @DisplayName("목이자 스텁인 storeMock")
    public void purchaseFailsWhenNotEnoughInventory() throws Exception {
        IStore storeMock = mock(IStore.class);
        when(storeMock.hasEnoughInventory(Product.Shampoo, 5)).thenReturn(false);
        LondonCustomer sut = new LondonCustomer();

        boolean success = sut.purchase(storeMock, Product.Shampoo, 5);

        Assertions.assertFalse(success);
        verify(storeMock, times(0)).removeInventory(Product.Shampoo, 5);
    }

}
