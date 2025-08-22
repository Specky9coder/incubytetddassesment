import com.incubyte.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {


    @Test
    void shouldReturnZeroForEmptyString() {
        Calculator calc = new Calculator();
        assertEquals(0, calc.add(""));
    }
}
