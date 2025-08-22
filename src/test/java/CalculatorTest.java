import com.incubyte.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {


    @Test
    void shouldReturnZeroForEmptyString() {
        Calculator calc = new Calculator();
        assertEquals(0, calc.add(""));
    }

    @Test
    void shouldReturnNumberForNumber() {
        Calculator calc = new Calculator();
        assertEquals(1, calc.add("1"));
    }

    @Test
    void shouldReturnSameNumberForSingleNumber() {
        Calculator calc = new Calculator();
        assertEquals(7, calc.add("7"));
    }

    @Test
    void shouldSumTwoNumbers() {
        Calculator calc = new Calculator();
        assertEquals(3, calc.add("1,2"));
    }

    @Test
    void shouldSumUnknownAmountOfNumbers() {
        Calculator calc = new Calculator();
        assertEquals(10, calc.add("1,2,3,4"));
    }

    @Test
    void shouldAllowNewLinesBetweenNumbers() {
        Calculator calc = new Calculator();
        assertEquals(6, calc.add("1\n2,3"));
    }

    @Test
    void shouldSupportCustomDelimiter() {
        Calculator calc = new Calculator();
        assertEquals(3, calc.add("//;\n1;2"));
    }

    @Test
    void shouldSupportMultipleDelimitersOfAnyLength() {
        Calculator calc = new Calculator();
        assertEquals(6, calc.add("//[**][%%]\n1**2%%3"));
    }


    @Test
    void shouldThrowExceptionForNegativeNumber() {
        Calculator calc = new Calculator();
        IllegalArgumentException ex =
                assertThrows(IllegalArgumentException.class, () -> calc.add("1,-2,3"));
        assertEquals("negatives not allowed: [-2]", ex.getMessage());
    }

    @Test
    void shouldThrowExceptionForMultipleNegatives() {
        Calculator calc = new Calculator();
        IllegalArgumentException ex =
                assertThrows(IllegalArgumentException.class, () -> calc.add("-1,-2,3"));
        assertEquals("negatives not allowed: [-1, -2]", ex.getMessage());
    }


    @Test
    void shouldIgnoreNumbersBiggerThan1000() {
        Calculator calc = new Calculator();
        assertEquals(2, calc.add("2,1001"));
    }

    @Test
    void shouldSupportLongDelimiter() {
        Calculator calc = new Calculator();
        assertEquals(6, calc.add("//[***]\n1***2***3"));
    }


    @Test
    void testGetCalledCount() {
        Calculator calc = new Calculator();

        assertEquals(0, calc.getCalledCount()); // initially zero

        calc.add("1,2");
        calc.add("3");

        assertEquals(2, calc.getCalledCount()); // should be 2 after two calls
    }

}
