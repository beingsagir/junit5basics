import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathUtilsTest {
    MathUtils mathUtils;

    @BeforeEach
    void init() {
        mathUtils = new MathUtils();
    }

    @Test
    void testAdd() {
        int expected = 2;
        assertEquals(expected, mathUtils.add(1, 1), "This should return the addition of two number");
    }

    @Test
    void testDivide(){
        assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0), "Divide by zero should through arithmetic exception");
    }

    @Test
    void testComputeCircleArea(){
        assertEquals(314.1592653589793, mathUtils.computeCircleArea(10), "Should return the area of a circle");
    }
}