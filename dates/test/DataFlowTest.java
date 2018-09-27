package dates.test;

import dates.Dates;
import org.junit.Test;
import static org.junit.Assert.fail;

public class DataFlowTest {

    /**
     * This tests a du-path for the "day" variable. It is defined as a parameter of
     * Dates.dayOfWeek, then has a p-use on line 61 and a c-use on line 75.
     * The du path from 46 to 75 is: 46,47,48,49,58,59,61,62,74,75.
     * This path is not tested in other cases because there were no dates tested with
     * a year divisible by 400 and after 1753, and a day less than 1.
     * This test improves the test suite by adding additional conditional coverage to
     * line 61 by testing a date where day <= 0. The other tests that run this line
     * either pass the predicate, or fail due to having a month <= 0.
     */
    @Test
    public void testDayDU() {
        try {
            Dates.Day day = Dates.dayOfWeek(2000,1,-1);
            fail("Invalid date should fail");
        } catch (IllegalArgumentException e) {
        }
    }
}
