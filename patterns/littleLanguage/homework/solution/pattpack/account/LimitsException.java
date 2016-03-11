package pattpack.account;

/** Exception thrown when an account usage exceeds its limits. */
public class LimitsException extends Exception {
    /**
     *  Construct an exception.
     *  @param message The message to report to the user.
     *    The message should explain which limit of an account usage
     *    is being exceeded.
     */
    public LimitsException (String message) { super (message); }
}






