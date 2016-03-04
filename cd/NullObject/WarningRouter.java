/**
 * This interface is implemented by classes whose instances can be used to
 * send warning message to an appropriate destination.
 */
public interface WarningRouter {
    /**
     * This method sends a warning message to whatever destination it
     * considers appropriate.
     * @return true if caller should proceed with its current operation.
     */
    public boolean routeWarning(String msg) ;
} // interface WarningRouter

