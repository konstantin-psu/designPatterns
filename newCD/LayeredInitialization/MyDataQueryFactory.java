import java.util.Hashtable;

/**
 * This is a Factory Method class for creating instances of classes that
 * perform database queries for JDBC or specific relational data bases.
 */
class MyDataQueryFactory implements DataQueryFactoryIF {
    private static Hashtable classes = new Hashtable();

    // populate the classes hashtable
    static {
        classes.put("INVENTORY", dataQuery.OracleQuery.class);
        classes.put("SALES",     dataQuery.SybaseQuery.class);
        classes.put("PERSONNEL", dataQuery.OracleQuery.class);
        classes.put("WHEATHER",  dataQuery.JDBCQuery.class);
        //...
    }

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
    public DataQueryFactoryIF createDataQueryImpl(String dbName) {
        Class clazz = (Class)classes.get(dbName);
        try {
            return (DataQueryFactoryIF)clazz.newInstance();
        } catch (Exception e) {
            return null;
        } // try
    } // createDataQueryImpl(String)
} // class MyDataQueryFactory
