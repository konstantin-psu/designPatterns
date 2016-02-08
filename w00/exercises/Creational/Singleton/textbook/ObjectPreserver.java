import java.util.HashSet;

/**
 * This class has methods to ensure that an object is never garbage
 * collected.
 */
public class ObjectPreserver implements Runnable {
    // This keeps this class and everything it references from being
    // garbage collected
    private static ObjectPreserver lifeLine = new ObjectPreserver();

    // Since this class won't be garbage collected, neither will this
    // HashSet or the object that it references.
    private static HashSet protectedSet = new HashSet();

    /**
     * Constructor.
     */
    private ObjectPreserver() {
        Thread tmp = new Thread(this);
	tmp.setDaemon (true);
	tmp.start();

    } // constructor()

    public synchronized void run() {
        try {
            wait();
        } catch (InterruptedException e) {
        } // try
    } // run()

    /**
     * Garbage collection of objects passed to this method will be
     * prevented until they are passed to the unpreserveObject method.
     */
    public static void preserveObject(Object o) {
        protectedSet.add(o);
    } // preserveObject()

    /**
     * Objects passed to this method lose the protection that the
     * preserveObject method gave them from garbage collection.
     */
    public static void unpreserveObject(Object o) {
        protectedSet.remove(o);
    } // unpreserveObject(Object)
} // class ObjectPreserver
