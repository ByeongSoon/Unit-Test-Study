package chapter11.leakingknowledge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTests {

    @Test
    @DisplayName("알고리즘 구현 유출")
    public void adding_two_numbers() {
        int value1 = 1;
        int value2 = 3;
        int expected = value1 + value2; // <- 유출

        int actual = Calculator.add(value1, value2);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("같은 테스트의 매개변수화 버전")
    @MethodSource("numberData")
    public void adding_rwo_numbers(int value1, int value2) {
        int expected = value1 + value2; // <- 유출

        int actual = Calculator.add(value1, value2);

        assertEquals(expected, actual);
    }

    private static Stream<Arguments> numberData() {
        return Stream.of(
            Arguments.of(1, 3),
            Arguments.of(11, 33),
            Arguments.of(100, 500)
        );
    }

    @Test
    @DisplayName("도메인 지식이 없는 테스트")
    @MethodSource("numberDataAndExpected")
    public void adding_two_numbers(int value1, int value2, int expected) {
        int actual = Calculator.add(value1, value2);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> numberDataAndExpected() {
        return Stream.of(
            Arguments.of(1, 3, 4),
            Arguments.of(11, 33, 44),
            Arguments.of(100, 500, 600)
        );
    }

}
