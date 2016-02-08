/**
 * Instances of this class represent a person.
 * A person has one or more roles that may change over time.
 */
class Person {
    /** The current role of this person. */
    private java.util.Set roles = new java.util.HashSet();
    /** Add one role of this person. */
    public void addRole(Role role) { roles.add(role); }
    /** Add one role of this person. */
    public void removeRole(Role role) { roles.remove(role); }
    /** Get something that depends of the role. */
    public Something getSomething() {
	Something something = null;
	java.util.Iterator iterator = roles.iterator();
	while (iterator.hasNext()) {
	    Role role = (Role) iterator.next();
	    // combine/choose something and role.getSomething()
	}
	return something;
    }    
} // class Person
