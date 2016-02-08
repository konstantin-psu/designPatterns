import java.util.Date;
/**
 * This class determines if a particular date is a according to a
 * collection of Holiday objects.
 */
public class CompositeHoliday extends Holiday {
    private Holiday[] holidayArray;

    /**
     * Constructor
     * @param h An array of Holiday objects
     */
    public CompositeHoliday(Holiday[] h) {
        holidayArray = new Holiday[h.length];
        System.arraycopy(h, 0, holidayArray, 0, h.length);
    } // CompositeHoliday

    /**
     * This method returns a array of strings that describe the holidays
     * that fall on the given date.  If no holidays fall on the given
     * date, then this method returns an array of length zero.
     * @param dt The date to check.
     */
    public String[] getHolidays(Date dt) {
        return getHolidays0(dt, 0, 0);
    } // getHolidays(Date)

    private String[] getHolidays0(Date dt, int offset, int ndx) {
        if (ndx >= holidayArray.length) {
            return new String[offset];
        } // if
        String[] holidays = holidayArray[ndx].getHolidays(dt);
        String[] result = getHolidays0(dt, offset+holidays.length, ndx+1);
        System.arraycopy(holidays, 0, result, offset, holidays.length);
        return result;
    } // getHolidays0(Date, int, int)
} // class USHoliday
