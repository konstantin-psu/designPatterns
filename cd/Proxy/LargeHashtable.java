import java.util.Enumeration;
import java.util.Hashtable;

/**
 * This subclass of Hashtable is functionally equivalent to Hashtable.  The
 * different is the way that it handles the clone operation.  Cloning a
 * Hashtable is an expensive operation.
 * <p>
 * One of the more common reasons for cloning an object like a Hashtable is to
 * avoid holding a lock on the object for a long time when all that is desired
 * is to fetch multiple key-value pairs.  In a multi-threaded program, the
 * usual way to ensure that a Hashtable is in a consistent state when you fetch
 * a value out of it is to have exclusive access to the Hashtable.  While that
 * is going on, other threads must wait to gain access to the same Hashtable, 
 * which may be unacceptable.
 * In some other cases it may not be possible to retain exclusive access.  An
 * example of that is the Enumeration object returned by the Hashtable class'
 * elements object.
 *<p>
 * Cloning a Hashtable prior to fetching values out of it is a defensive
 * measure.  If some other thread comes along and changes the contents of a
 * Hashtable that you are fetching values from, then you may get some
 * inconsittent results.  Cloning the Hashtable avoids that problem since the
 * hashtable you are reading from is a copy of the original that is only
 * accessible to the whatever objects have visibility to the copy.
 *<p>
 * If, after you clone a hashtable, there is no subsequent modification to the
 * Hashtable, then the time and memory spent in creating the clone is wasted.
 * The point of this class is to avoid that waste.  It does that by delaying
 * the cloning of the Hashtable until a modification to the Hashtable actually
 * occurs.
 *<p>
 * Instances of this class are a copy-on-write proxy for a Hashtable object.
 * When a proxy's clone method is called, it returns a copy of the proxy but
 * does not copy the hashtable object.  At that point both the original and
 * copy of the proxy refer to the same Hashtablec object.  When either of the
 * proxies is asked to modify the Hashtable, they recognize that they are
 * using a shared Hashtable and clone the Hashtable before they make the
 * modification.
 *<p>
 * The way that the proxies know that they are working with a shared Hashtable
 * object is that the Hashtable object that proxies work with is an instance
 * of a private subclass of Hashtable called ReferenceCountedHashTable.  The
 * ReferenceCountedHashTable keeps a count of how many proxies refer to it.
 */
public class LargeHashtable extends Hashtable {
    // The ReferenceCountedHashTable that this is a proxy for.
    private ReferenceCountedHashTable theHashTable;
    
    /**
     * Construct an empty hashtable.
     * @param      initialCapacity   the initial capacity of the hashtable.
     * @param      loadFactor        a number between 0.0 and 1.0.
     * @exception  IllegalArgumentException  if initialCapacity <=0
     *               or loadFactor <= 0
     */
    public LargeHashtable(int initialCapacity, float loadFactor) {
        theHashTable = new ReferenceCountedHashTable(initialCapacity,
                                                     loadFactor);
    } // constructor(int, float)

    /**
     * Construct an empty hashtable.
     * @param      initialCapacity   the initial capacity of the hashtable.
     * @exception  IllegalArgumentException  if initialCapacity <=0
     */
    public LargeHashtable(int initialCapacity) {
        theHashTable = new ReferenceCountedHashTable(initialCapacity);
    } // constructor(int)

    /**
     * Construct an empty hashtable with a default capacity and load factor. 
     */
    public LargeHashtable() {
        theHashTable = new ReferenceCountedHashTable();
    } // constructor()

    /**
     * Return the number of key-value pairs in this hashtable.
     */
    public int size() {
        return theHashTable.size();
    } // size()

    /**
     * Return true if this Hashtable contains no key-value pairs.
     */
    public boolean isEmpty() {
        return theHashTable.isEmpty();
    } // isEmpty()

    /**
     * Return an enumeration of the keys in this Hashtable.
     */
    public synchronized Enumeration keys() {
        return theHashTable.keys();
    } // keys()

    /**
     * Return an enumeration of the values in this Hashtable.
     */
    public synchronized Enumeration elements() {
        return theHashTable.elements();
    }

    /**
     * Return true if the given value is part of a key-value pair in this
     * Hashtable 
     * This operation is more expensive and requires a linear search.
     * @param      value   The value to search for.
     * @exception  NullPointerException  if the value is <code>null</code>.
     */
    public synchronized boolean contains(Object value) {
        return theHashTable.contains(value);
    } // contains(Object)

    /**
     * Return true if the given key is in this hashtable.
     * @param   key   The key to search for.
     */
    public synchronized boolean containsKey(Object key) {
        return theHashTable.containsKey(key);
    } // containsKey(Object)

    /**
     * Return the value associated with the specified key in this Hashtable.
     * @param   key   a key in the hashtable.
     */
    public synchronized Object get(Object key) {
        return theHashTable.get(key);
    } // get(key)

    /**
     * Add the given key-value pair to this Hashtable.
     * @param      key     the key.
     * @param      value   the value.
     * @return     the previous value of the given key in this hashtable,
     *             or <code>null</code> if it did not have one.
     * @exception  NullPointerException  if the key or value is
     *               <code>null</code>.
     */
    public synchronized Object put(Object key, Object value) {
        copyOnWrite();
        return theHashTable.put(key, value);
    } // put(key, value)

    /**
     * Remove the key-value pair having the given key from this Hashtable.
     * @param   key   the key that needs to be removed.
     */
    public synchronized Object remove(Object key) {
        copyOnWrite();
        return theHashTable.remove(key);
    } // remove(Object)

    /**
     * Remove all key-value pairs from this Hashtable.
     */
    public synchronized void clear() {
        copyOnWrite();
        theHashTable.clear();
    } // clear()

    /**
     * Return a copy of this proxy that accesses the same Hashtable as this
     * proxy. The first attempt for either to modify the contents of the
     * Hashtable results in that proxy accessing a modified clone of the
     * original Hashtable.
     */
    public synchronized Object clone() {
        Object copy = super.clone();
        theHashTable.addProxy();
        return copy;
    } // clone()

    /**
     * This method is called before modifying the underlying Hashtable.  If it
     * is being shared then this method clones it.
     */
    private void copyOnWrite() {
        if (theHashTable.getProxyCount() > 1) {
            // Synchronize on the original Hashtable to allow consistent
            // recovery on error.
            synchronized (theHashTable) {
                theHashTable.removeProxy();
                try {
                    theHashTable
                      = (ReferenceCountedHashTable)theHashTable.clone();
                } catch (Throwable e) {
                    theHashTable.addProxy();
                } // try
            } // synchronized
        } // if proxyCount
    } // copyOnWrite()

    /**
     * Return a string representation of this Hashtable.
     */
    public synchronized String toString() {
        return theHashTable.toString();
    }

    private class ReferenceCountedHashTable extends Hashtable {
        private int proxyCount = 1;
    
        /**
         * Construct an empty hashtable.
         * @param      initialCapacity   the initial capacity of the hashtable.
         * @param      loadFactor        a number between 0.0 and 1.0.
         * @exception  IllegalArgumentException  if initialCapacity <=0
         *               or loadFactor <= 0
         */
        public ReferenceCountedHashTable(int initialCapacity,
                                         float loadFactor) {
            super(initialCapacity, loadFactor);
        } // constructor(int, float)

        /**
         * Construct an empty hashtable.
         * @param      initialCapacity   the initial capacity of the hashtable.
         * @exception  IllegalArgumentException  if initialCapacity <=0
         */
        public ReferenceCountedHashTable(int initialCapacity) {
            super(initialCapacity);
        } // constructor(int)

        /**
         * Construct an empty hashtable with default capacity and load factor. 
         */
        public ReferenceCountedHashTable() {
            super();
        } // constructor()

        /**
         * Return a copy of this object with proxyCount set back to 1.
         */
        public synchronized Object clone() {
            ReferenceCountedHashTable copy;
            copy = (ReferenceCountedHashTable)super.clone();
            copy.proxyCount = 1;
            return copy;
        } // clone()

        /**
         * Return the number of proxies using this object.
         */
        synchronized int getProxyCount() {
            return proxyCount;
        } // getProxyCount()

        /**
         * Increment the number of proxies using this object by one.
         */
        synchronized void addProxy() {
            proxyCount++;
        } // addProxy()

        /**
         * Decrement the number of proxies using this object by one.
         */
        synchronized void removeProxy() {
            proxyCount--;
        } // removeProxy()
    } // class ReferenceCountedHashTable
} // class LargeHashtable
