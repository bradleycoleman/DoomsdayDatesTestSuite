package dates.test;

import dates.Dates;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class EquivalenceTest {

    /**
     * Tests the equivalence class for valid dates that aren't in February, but
     * are in a leap year. This equivalence class wasn't tested in the other tests
     * as there were no valid dates tested that were not in February, but were in a leap
     * year. This test improves the test suite by adding additional conditional coverage
     * to lines 65, and 96. The test adds additional conditional coverage to line 65 by
     * testing a leap year date where month != 2. The other tests that ran this line either
     * failed this predicate by not being leap years, or passed. It also adds
     * additional conditional coverage to line 96 by testing a leap year date where
     * month > 2. The other tests that ran this predicate failed by not being leap
     * years, or passed.
     */
    @Test
    public void testDayDU() {
       assertEquals(Dates.Day.Friday,Dates.dayOfWeek(2004,3,5));
    }
}
