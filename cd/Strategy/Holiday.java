import java.util.Date;
/**
 * This abstract class is the superclass of classes that can determine
 * if a date is a holiday. Subclasses of this class will be specific to
 * nations or religions.
 */
public abstract class Holiday {
    protected final static String[] noHoliday = new String[0];
    /**
     * This method returns a array of strings that describe the holidays
     * that fall on the given date.  If no holidays fall on the given
     * date, then this method returns an array of length zero.
     * @param dt The date to check.
     */
    abstract public String[] getHolidays(Date dt) ;
} // class Holiday
