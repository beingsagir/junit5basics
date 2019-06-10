import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MathUtilsTest {
    MathUtils mathUtils;

    @BeforeAll
    static void startBeforeInitialization(){
        System.out.println("start even before the creation of the current class");
    }

    @BeforeEach
    void init() {
        mathUtils = new MathUtils();
    }

    @AfterEach
    void end(){
        System.out.println("Test is done");
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
    @DisplayName("test simple divide in divideTest")
    void testDivideTwo(){
        int expected = 2;
        assertEquals(expected, mathUtils.divide(4, 2), "Divide by zero should through arithmetic exception");
    }

    @Test
    @EnabledOnOs(OS.LINUX)
    @DisplayName("test simple divide in linux only")
    void testDivideOnlyForLinux(){
        int expected = 2;
        assertEquals(expected, mathUtils.divide(4, 2), "Divide by zero should through arithmetic exception");
    }

    @Test
    @DisplayName("test simple divide with assumptions")
    void testDivideAssumptions(){
        assumeTrue(1==1);
        int expected = 2;
        assertEquals(expected, mathUtils.divide(4, 2), "Divide by zero should through arithmetic exception");
    }

    @Test
    @Disabled
    @DisplayName("TDD should not fell")
    void testFail(){
        fail("manual fail");
    }

    @Test
    void testComputeCircleArea(){
        assertEquals(314.1592653589793, mathUtils.computeCircleArea(10), "Should return the area of a circle");
    }
}