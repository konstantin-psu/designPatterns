package expr;

import java.io.*;
import java.util.*;

/**
 * This class is a factory for shared variables in the
 * abstract syntax representation of programs in a "while" language.
 * It implements the Singleton pattern.
 */
public class VarFactory {
    private static VarFactory varFactory = null;
    private VarFactory () {}
    private Hashtable table = new Hashtable ();
    /**
     * Intialize and return the unique instance of this class.
     * This method should be called only once throughout an entire
     * program execution.
     * @param filename The name of the file to log messages to.
     * @param verbose Verbosity level: the higher the value the more is logged.
     * @param realtime If true logged messages are immediately printed
     *                 on standard error.
     * @return The unique instance of the varFactory object.
     */
    public static VarFactory getInstance () {
	if (varFactory != null)
	    throw new RuntimeException ("VarFactory already initialized");
	else
	    varFactory = new VarFactory ();
	return varFactory;
    }
    /**
     *  Return a shared variable or literal with the given identifier.
     *  The variable is held by a table and shared through references.
     */
    public Variable makeVar (String name, int line) {
	if (! table.containsKey (name))
	    table.put (name, new SimpleVar (name));
	return new VarWithLine ((Variable) table.get (name), line);
    }

}
