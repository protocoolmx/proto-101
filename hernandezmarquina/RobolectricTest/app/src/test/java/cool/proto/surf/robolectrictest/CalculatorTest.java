package cool.proto.surf.robolectrictest;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by pablo on 19/01/17.
 */

public class CalculatorTest {

    Calculator calculator;

    @Test
    public void sum() throws Exception {

        int num1 = 20;
        int num2 = 30;
        int resultExpected = num1 + num2;

        calculator = new Calculator();

        assertTrue("sum is incorrect", calculator.sum(num1, num2).equals(Integer.toString(resultExpected)));

    }
}
