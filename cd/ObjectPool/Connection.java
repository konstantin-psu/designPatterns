/**
 * Public class used outside of the database access library to represent
 * a database connection.
 */
public class Connection {
    private final static ConnectionImpl.ConnectionPool
      connectionPool = ConnectionImpl.ConnectionPool.getInstance();
    private String databaseName;

    //...

    /**
     * Send a request to the database and return the result.
     */
    Object sendRequest(Request request) {
        Object result;
        ConnectionImpl impl = connectionPool.acquireImpl(databaseName);
        result = impl.sendRequest(request);
        connectionPool.releaseImpl(impl);
        return result;
    } // sendRequest(Request)
} // class Connection
