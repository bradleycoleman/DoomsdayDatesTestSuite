package dates.test;
import dates.Dates;
import org.junit.Test;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;

public class BranchTests {

    /**
     * Tests a valid date not on a leap year, and after the doomsday of the month. This does not achieve 100% branch
     * coverage because the for predicate on line 92 is never false
     */
    @Test
    public void testNoLYValidAfterDD() {
        assertEquals(Dates.Day.Thursday, Dates.dayOfWeek(1999,9,9));
    }

    /**
     * Tests a date with an invalid (month>12) date that is not on a leap year
     */
    @Test
    public void testNoLYBigMonth() {
        try {
            Dates.Day day = Dates.dayOfWeek(1999, 13, 1);
            fail("Should fail invalid date");
        } catch (IllegalArgumentException e) {
        }
    }

    /**
     * Tests an invalid (day>31) date that is not on a leap year
     */
    @Test
    public void testNoLYBigDay() {
        try {
            Dates.Day day = Dates.dayOfWeek(1999, 12, 40);
            fail("Should fail invalid date");
        } catch (IllegalArgumentException e) {
        }
    }

    /**
     * Tests an invalid (year<1753) date that is divisible by 400
     */
    @Test
    public void testDiv400Before1753() {
        try {
            Dates.Day day = Dates.dayOfWeek(1600, 12, 12);
            fail("Should fail invalid date");
        } catch (IllegalArgumentException e) {
        }
    }

    /**
     * Tests an invalid (month=0) date that is divisible by 100 (is not leap year)
     */
    @Test
    public void testDiv100ZeroMonth() {
        try {
            Dates.Day day = Dates.dayOfWeek(1800, 0, 12);
            fail("Should fail invalid date");
        } catch (IllegalArgumentException e) {
        }
    }

    /**
     * Tests a valid date which is on a leap year (div by 4), the day is before the
     * doomsday of the month
     */
    @Test
    public void testDiv4Month2ValidDayBeforeDD() {
        assertEquals(Dates.dayOfWeek(1996, 2, 3), Dates.Day.Saturday);
    }

    /**
     * Tests an invalid (month=2,day>28) date which is on a leap year (div by 4)
     */
    @Test
    public void testDiv4Month2BigDay() {
        try {
            Dates.Day day = Dates.dayOfWeek(1996, 2, 31);
            fail("Should fail invalid date");
        } catch (IllegalArgumentException e) {
        }
    }
}
