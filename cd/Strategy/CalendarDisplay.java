import java.util.Date;

/**
 * Skeletal definition of class to display a calendar
 */
class CalendarDisplay {
    private Holiday holiday;
    private static final String[]noHoliday = new String[0];
    //...
    /**
     * Instances of this private class are used to cache information about
     * dates that are to be displayed.
     */
    private class DateCache {
        private Date date;
        private String[] holidayStrings;

        DateCache(Date dt) {
            date = dt;
            //...
            if (holiday == null) {
                holidayStrings = noHoliday;
            } else {
                holidayStrings = holiday.getHolidays(date);
            } // if
            //...
        } // constructor(Date)
    } // class DateCache
} // class CalendarDisplay

