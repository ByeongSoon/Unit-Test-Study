package chapter04.extreme;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    @DisplayName("간단한 코드를 다루는 간단한 테스트")
    public void test() {
        User sut = new User();

        sut.name = "John Smith";

        Assertions.assertEquals("John Smith", sut.name);
    }

}
