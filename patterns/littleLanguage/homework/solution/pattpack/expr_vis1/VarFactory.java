package pattpack.expr_vis1;

import java.io.*;
import java.util.*;

/**
 * This class is a factory for shared variables in the
 * abstract syntax representation of programs in a "while" language.
 * It implements the Singleton pattern.
 */
public class VarFactory {
    private static VarFactory varFactory = new VarFactory ();
    // Private constructor!!! The default is public.
    private VarFactory () {}
    private Hashtable table = new Hashtable ();
    /**
     * Intialize and return the unique instance of this class.
     * @return The unique instance of the varFactory object.
     */
    public static VarFactory getInstance () { return varFactory; }
    /**
     *  Return a shared variable with the given identifier.
     *  The variable is held by a table and shared through references.
     */
    public Variable makeVar (String name) {
	if (! table.containsKey (name))
	    table.put (name, new Variable (name));
	return (Variable) table.get (name);
    }
    /**
     *  Return a literal.
     *  Literals are shared similarly to variables.
     */
    public Variable makeVar (int value) {
	String name = String.valueOf (value);
	if (! table.containsKey (name))
	    table.put (name, new Variable (name, value));
	return (Variable) table.get (name);
    }
}
