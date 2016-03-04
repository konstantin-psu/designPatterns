package dataQuery;

/**
 * Factory classes that create instances of classes that implement the
 * DataQueryImplIF interface must implement this interface.
 */
public interface DataQueryFactoryIF {
    /**
     * Create a DataQueryImplIF object that retrieves data from the
     * specified database.
     * @param dbName the name of the database that will be queried
     * @return An instance of a class that that is specific to either
     *         JDBC or the physical database engine that the database
     *         runs on.
     *         If the specified database is not know to this method, it
     *         returns null.
     */
    public DataQueryFactoryIF createDataQueryImpl(String dbName);
} // DataQueryFactoryIF
