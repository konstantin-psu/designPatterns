package dataQuery;

/**
 * This class takes a database query and returns a result.
 */
public class DataQuery {
    // Factory object for creating DataQueryImplIF objects.
    private static DataQueryFactoryIF factory;

    /**
     * Set the factory object
     * @exception Error if this method is called after a factory has
     *                  been set 
     */
    public static void setFactory(DataQueryFactoryIF myFactory) {
        if (this.factory != null)
          throw new Error("Data query factory already defined");
        factory = myFactory;
    } // setFactory(DataQueryFactoryIF)
    
    /**
     * Constructor
     * @param query A string containing the query
     */
    public DataQuery(String query) {
        //...
        while ( /*...*/ ) {
            String dbName = null;
            //...
            // Construct a database specific query object
            DataQueryImplIF dq;
            dq = (DataQueryImplIF)factory.createDataQueryImpl(dbName);
            //...
        } // while
        //...
    } // Constructor(String)
    //...
} // class DataQuery
