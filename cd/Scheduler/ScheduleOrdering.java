/**
 * Objects used to specify the processing that the resource managed by a
 * Scheduler object uses implement this interface.
 */
public interface ScheduleOrdering {
    public boolean scheduleBefore(ScheduleOrdering s);
} // interface ScheduleOrdering
