package pattpack.expr_intr;

import java.io.*;
import java.util.*;

/**
 * This class is a factory for shared variables in the
 * abstract syntax representation of programs in a "while" language.
 * It implements the Singleton pattern.
 */
public class VarFactory {
    /** The singleton instance of this class */
    private static VarFactory varFactory = new VarFactory ();
    /** Private constructor for singleton pattern */
    private VarFactory () {}
    /** Table holding the variables */
    private Hashtable table = new Hashtable ();
    /**
     * Return the unique instance of this class.
     * @return The unique instance of the varFactory object.
     */
    public static VarFactory getInstance () { return varFactory; }
    /**
     *  Return a shared variable or literal with the given identifier.
     *  The variable is held by a table and shared through references.
     *  The variable is created the first time it is requested.
     *  @param name The name of the variable to create and/or return.
     *  @return The requested variable.
     */
    public Variable makeVar (String name) {
	if (! table.containsKey (name))
	    table.put (name, new Variable (name));
	return (Variable) table.get (name);
    }

}
