import java.util.Hashtable;
import java.util.Vector;

/**
 * Instances of this class provide actual connections to a database.
 */
class ConnectionImpl {
    // Name of the datbase this object connected to.
    private String dbName;

    // Private Constructor
    private ConnectionImpl(String dbName) {
        this.dbName = dbName;
        //...
    } // constructor()
    //...

    /**
     * return the name of the database that this objects is connected to.
     */
    String getDatabaseName() {
        return dbName;
    } // getDatabaseName()
    
    /**
     * Send a request to the database and return the result.
     */
    Object sendRequest(Request request) {
        Object result = null;
        //...
        return result;
    } // sendRequest(Request)
    //...
    static class ConnectionPool {
        // The one instance of this class
        private static ConnectionPool thePool = new ConnectionPool();

        // This hash table is associates database names with the a
        // corresponding Vector that contains a pool of connections for
        // that database.
        private Hashtable poolDictionary = new Hashtable();

        // This constructor is private to prevent other classes from
        // creating instances of this class.
        private ConnectionPool() {}

        /**
         * Return the one instance of this class.
         */
        public static ConnectionPool getInstance() {
            return thePool;
        } // getInstance()

        /**
         * Return a ConnectionImpl from the apropriate pool or create one
         * if the pool is empty.
         * @param dbName The name of the database that a ConnectionImpl
         *        is to be supplied for.
         */
        public synchronized ConnectionImpl acquireImpl(String dbName) {
            Vector pool = (Vector)poolDictionary.get(dbName);
            if (pool != null) {
                int size = pool.size();
                if (size > 0)
                  return (ConnectionImpl)pool.remove(size-1);
            } // if null

            // No ConnectionImpl in pool, so create one.
            return new ConnectionImpl(dbName);
        } // acquireImpl(String)

        /**
         * Add a ConnectionImpl to the appropriate pool.
         */
        public synchronized void releaseImpl(ConnectionImpl impl) {
            String databaseName = impl.getDatabaseName();
            Vector pool = (Vector)poolDictionary.get(databaseName);
            if (pool == null) {
                pool = new Vector();
                poolDictionary.put(databaseName, pool);
            } // if null
            pool.addElement(impl);
        } // releaseImpl(ConnectionImpl)
    } // class ConnectionPool
} // class ConnectionImpl
