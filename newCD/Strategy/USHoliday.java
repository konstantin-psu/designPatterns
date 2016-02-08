import java.util.Date;
/**
 * This class determines if a particular date is a U.S. holiday.
 */
public class USHoliday extends Holiday {
    /**
     * This method returns a array of strings that describe the holidays
     * that fall on the given date.  If no holidays fall on the given
     * date, then this method returns an array of length zero.
     * @param dt The date to check.
     */
    public String[] getHolidays(Date dt) {
        String[] holidays = noHoliday;
        //...
        return holidays;
    } // getHolidays(Date)
} // class USHoliday
