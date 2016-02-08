/**
 * Instances of this class identify an employee.
 */
class EmployeeID {
    private String id;

    /**
     * constructor
     * @param id A string containing the employee ID.
     */
    public EmployeeID(String id) {
        this.id = id;
    } // constructor(String)

    /**
     * Returns a hash code value for this object.
     */
    public int hashCode() { return id.hashCode(); }

    /**
     * Return true if the given object is an employee id that is equal to this
     * one.
     * @param obj The object to compare with this one.
     */
    public boolean equals(Object obj) {
        return ( obj instanceof EmployeeID
                 && id.equals(((EmployeeID)obj).id) );
    } // equals(Object)

    /**
     * Return the string representation of this EmployeeID.
     */
    public String toString() { return id; }
} // class EmployeeID

