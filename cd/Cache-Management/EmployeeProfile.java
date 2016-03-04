import java.util.Locale;

/**
 * Instances of this class contain employee profile information
 */
class EmployeeProfile {
    private EmployeeID id;      // Employee Id
    private Locale locale;      // Language Preference
    private boolean supervisor;
    private String name;        // Employee name

    /**
     * Constructor
     * @param id Employee Id
     * @param locale The locale of the employee's language of choice.
     * @param supervisor true if this employee is a supervisor.
     * @param name Employee's name
     */
    public EmployeeProfile(EmployeeID id,
                           Locale locale,
                           boolean supervisor,
                           String name) {
        this.id = id;
        this.locale = locale;
        this.supervisor = supervisor;
        this.name = name;
    } // Constructor(EmployeeID, Locale, boolean, String)

    /**
     * Return the employee's ID
     */
    public EmployeeID getID() { return id; }

    /**
     * return the Locale indicating the Employee's preferred language.
     */
    public Locale getLocale() { return locale; }

    /**
     * Return true if the employee is a supervisor.
     */
    public boolean isSupervisor() { return supervisor; }
} // class EmployeeProfile
