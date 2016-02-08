/**
 * Classes that implement this interface can be compared for equality by the
 * compare operator.  It is modeled on interface 
 * <EM>java.lang.Comparable<EM>.
 */
public interface ComparableIF {
    /**
     *  Compare two objects.
     *  @param x The object to compare against this object.
     *  @return The result of the comparison, which is either
     *          true or false depending on both the objects <B>and</B>
     *          the logic of the application.
     */
    boolean compare (ComparableIF x);
}
