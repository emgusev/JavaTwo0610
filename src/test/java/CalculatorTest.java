import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import lesson14.Battery;
import lesson14.Calculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

public class CalculatorTest {

    Calculator calculator;
    Battery battery = Mockito.mock(Battery.class);
    //mock

    @BeforeEach
    void init() {
        System.out.println("initialization");

        calculator = new Calculator(battery);
    }

    //void - do nothing
    //method - null


    @AfterEach
    void tearDown(){
        System.out.println("test finished");
    }


    @Test
    @DisplayName("тестирование сложения")
    void testAddition() {
        Assertions.assertEquals(10, calculator.sum(3, 7), "sum should be equal 10");
    }

    @Test
    //@Disabled
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    void testMuliplication() {
        Assertions.assertEquals(15, calculator.multiply(3, 5));
    }

    @Test
    void testDivisionWithException() {
        Assertions.assertThrows(ArithmeticException.class, () -> calculator.division(10,0));
    }

    @CsvSource({
            "1, 2, 3",
            "3, 2, 5",
            "13, 2, 15"
    })
    @ParameterizedTest
    void testAdditionMultiple(int a, int b, int result) {
        Assertions.assertEquals(result, calculator.sum(a,b));
    }


    @MethodSource("dataForAddition")
    @ParameterizedTest
    void testAdditionMultipleWithMethod(int a, int b, int result) {
        Assertions.assertEquals(result, calculator.sum(a,b));
    }

    public static Stream<Arguments> dataForAddition () {
        List<Arguments> arguments= new ArrayList<>();
        Random random = new Random();
        for (int i=0; i < 1000; i++) {
            int a = random.nextInt(1000);
            int b = random.nextInt(1000);
            arguments.add(Arguments.arguments(a, b, a + b));
        }

        return arguments.stream();
    }


    void testWithBattery() {
        Mockito.doReturn(50).when(battery.getPercent());
    }

    //Business Development Sales and Marketing

    //JsonAssert

    //SODD
}
