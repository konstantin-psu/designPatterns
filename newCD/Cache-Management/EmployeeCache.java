import java.util.Hashtable;
import java.util.Vector;

/**
 * Instances of this class are responsible for maintaining a cache of
 * objects for a CacheManager object. 
 */
class EmployeeCache {
    /**
     * We use a linked list to determine the least recently used employee
     * profile.  The cache that itself is implemented by a Hashtable
     * object. The Hashtable values are linked list objects that refer
     * to the actual EmployeeProfile object.
     */
    private Hashtable cache = new Hashtable();

    /**
     * This is the head of the linked list that refers to the most
     * recently used EmployeeProfile.
     */
    LinkedList mru = null;

    /**
     * this is the end of the linked list that referes to the least
     * recently used EmployeeProfile.
     */
    LinkedList lru = null;

    /**
     * The maximum number of EmployeeProfile objects that may be in the
     * cache.
     */
    private final int MAX_CACHE_SIZE = 80;

    /**
     * The number of EmployeeProfile objects currently in the cache.
     */
    private int currentCacheSize = 0;

    /**
     * Objects are passed to this method for addition to the cache.
     * However, this method is not required to actually add an object
     * to the cache if that is contrary to its policy for what object
     * should be added.  This method may also remove objects already in
     * the cache in order to make room for new objects.
     * @param emp The employeeProfile that is being proposed as an
     *            addition to the cache.
     */
    public void addEmployee(EmployeeProfile emp) {
        EmployeeID id = emp.getID();
        if (cache.get(id) == null) { // if profile not in cache
            // Add profile to cache, making it the most recently used.
            if (currentCacheSize == 0) {
                // treate empty cache as a special case
                lru = mru = new LinkedList();
                mru.profile = emp;
            } else {            // currentCacheSize > 0
                LinkedList newLink;
                if (currentCacheSize >= MAX_CACHE_SIZE) {
                    // remove least recently used EmployeeProfile from
                    // the cache
                    newLink = lru;
                    lru = newLink.previous;
                    cache.remove(id);
                    currentCacheSize--;
                    lru.next = null;
                } else {
                    newLink = new LinkedList();
                } // if >= MAX_CACHE_SIZE
                newLink.profile = emp;
                newLink.next = mru;
                mru.previous = newLink;
                newLink.previous = null;
                mru = newLink;
            } // if 0
            // put the now most recently used profile in the cache
            cache.put(id, mru);
            currentCacheSize++;
        } else {                // profile already in cache
            // addEmployee shouldn't be called when the object is already
            // in the cache.  Since that has happened, do a fetch so
            // that so object becomes the most recently used.
            fetchEmployee(id);
        } // if cache.get(id)
    } // addEmployee(EmployeeProfile)

    /**
     * Return the EmployeeProfile associated with the given EmployeeID
     * the cache or null if no EmployeeProfile is associated witht the
     * given EmployeeID.
     * @param id the EmployeeID to retrieve a profile for.
     */
    public EmployeeProfile fetchEmployee(EmployeeID id) {
        LinkedList foundLink = (LinkedList)cache.get(id);
        if (foundLink == null)
          return null;
        if (mru != foundLink) {
            if ( foundLink == lru ) {
                lru = foundLink.previous;
                lru.next = null;
            } // if lru
            if (foundLink.previous != null)
              foundLink.previous.next = foundLink.next;
            if (foundLink.next != null)
              foundLink.next.previous = foundLink.previous;
            mru.previous = foundLink;
            foundLink.previous = null;
            foundLink.next = mru;
            mru = foundLink;
        } // if currentCacheSize > 1
        return foundLink.profile;
    } // fetchEmployee(EmployeeID)

    /**
     * private doublely linked list class for managing list of most
     * recently used employee profiles.
     */
    private class LinkedList {
        EmployeeProfile profile;
        LinkedList previous;
        LinkedList next;
    } // class LinkedList
} // class EmployeeCache

