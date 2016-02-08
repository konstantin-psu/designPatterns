import java.util.Date;

/**
 * An instance of this class is created to detail the passing or
 * rejection of someone from a security checkpoint.
 */
public class JournalEntry implements ScheduleOrdering {
    private boolean passed;     // true if badge holder was passed
                                // through security checkpoint
    private SecurityCheckpoint checkpoint;
    private Date time;

    /**
     * constructor
     * @param passed True if badge holder was passed through the
     *               security checkpoint.
     * @param checkpoint The security checkpoint a badge holder was
     *                   passed through or rejected from.
     */
    JournalEntry(boolean passed,
                 SecurityCheckpoint checkpoint) {
        this.passed = passed;
        this.checkpoint = checkpoint;
        time = new Date();
    } // constructor(boolean, SecurityCheckpoint, Date)

    /**
     * Return this JournalEntry's checkpoint
     */
    public SecurityCheckpoint getCheckpoint() { return checkpoint; }

    /**
     * Return true if badge holder passed throuth the checkpoint.
     */
    public boolean getPassed() { return passed; }

    /**
     * return the time that this JournalEntry was created.
     */
    public Date getTime() { return time; }

    /**
     * Return true if the given request should be scheduled before this
     * one.
     */
    public boolean scheduleBefore(ScheduleOrdering s) {
        if (s instanceof JournalEntry)
          return getTime().before(((JournalEntry)s).getTime());
        return false;
    } // scheduleBefore(ScheduleOrdering)
} // class JournalEntry
