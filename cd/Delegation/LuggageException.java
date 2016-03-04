/**
 * An instance of this is thrown when a requested operation on luggage
 * cannot be performed.
 */
public class LuggageException extends Exception {
    /**
     * Constructor.
     * @param msg Message to assocate with this exception.
     */
    public LuggageException(String msg) {
        super(msg);
    } // LuggageException(String)
} // class LuggageException

