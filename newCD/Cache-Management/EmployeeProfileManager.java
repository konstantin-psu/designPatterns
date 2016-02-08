/**
 * Instances of this class retrieve the EmployeeProfile associated
 * with an EmployeeID. 
 */
class EmployeeProfileManager {
    private EmployeeCache cache = new EmployeeCache();
    private EmployeeProfileFetcher server
      = new EmployeeProfileFetcher();

    /**
     * Fetch an employee profile for the given employee id from the
     * internal cache or timekeeping server if the profile is not
     * found in the internal cache.
     * @param id the employee's id
     * @ return the employee's profile or null if the employee's
     *          profile is not found on the timekeeping server.
     */
    EmployeeProfile fetchEmployee(EmployeeID id) {
        EmployeeProfile profile = cache.fetchEmployee(id);
        if (profile == null) {   // if profile not in cache try server
            profile = server.fetchEmployee(id);
            if (profile != null) { // Got the profile from the server
                // put profile in the cache
                cache.addEmployee(profile);
            } // if != null
        } // if == null
        return profile;
    } // fetchEmployee(EmployeeID)
} // class EmployeeProfileManager
