import java.util.Vector;
/**
 * Instances of this class represent an airline reservation system person.
 */
class PersonWithRoles {
    //...
    /** All the roles played by this PersonWithRoles. */
    private Vector roles = new Vector ();
    /**
     * Add a Role to this PersonWithRoles
     * @param role The role this PersonWithRoles plays.
     * @exception IncompatiblePersonException if the person of the added role
     *            is different from the person of other existing roles.
     */
    void addRole (Role role) throws IncompatiblePersonException {
	Person person = role.getPerson ();
	// We check all roles, but checking one only should suffice !
	for (int i = 0; i < roles.size (); i++)
	    if (((Role) roles.elementAt (i)).getPerson () != person)
		throw new IncompatiblePersonException (person.getName ());
	roles.addElement (role);
    } // method addRole
} // class PersonWithRoles
