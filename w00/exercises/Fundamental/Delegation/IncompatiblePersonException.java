/**
 * Instances of this class are thrown when two roles of a
 * PersonWithRoles are not played by the same Person.
 */
public class IncompatiblePersonException extends Exception {
    /**
     * Constructor
     * @param msg The message string to associate with this exception
     *            object.
     */
    public IncompatiblePersonException (String msg) { super(msg); }
} // class IncompatiblePersonException

