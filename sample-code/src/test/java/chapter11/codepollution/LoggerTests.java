package chapter11.codepollution;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LoggerTests {

    @Test
    @DisplayName("스위치를 사용한 테스트")
    public void some_test() {
        Logger logger = new Logger(true);
        Controller sut = new Controller();

        sut.someMethod(logger);

        // 검증
    }



}
