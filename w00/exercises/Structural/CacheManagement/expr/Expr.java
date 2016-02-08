package expr;

import java.util.*;

/**
 *  This class defines the methods available in every expression.
 *  It also serves as a cache manager of expressions's values.
 */
public abstract class Expr {
    /**
     *  Evaluate this expressions.
     *  This method fetches the cached value of this expression.
     *  Subclasses may override it when computing the value
     *  from an expression's state is more efficient than fetching it,
     *  e.g., in a literal.
     *  @return The value of this expression.
     */
    public int eval () { return eval (this); }
    /**
     *  This method computes the value of an expression from scratch,
     *  i.e., without using the cached value, if any exists.
     *  A subclas should generally override this method,
     *  unless the subclass overrides the eval method in a way
     *  that makes no use of the cache.
     *  In this class, this method throws NoSuchMethodError.
     *  @return The value of this expression.
     */
    protected int uncachedEval () { throw new NoSuchMethodError (); }
    // The cache of expressions's values
    private static Hashtable table = new Hashtable ();
    // This method always return the value of an expression.
    // First it tries to fetch the value of its argument from
    // the cache.  If not value has been cached already, it
    // calls method uncachedEval, caches the value and also
    // returns it.
    // @param key The expression to evaluate.
    // @return the value of the argument.
    private static int eval (Expr key) {
	Integer cached = (Integer) table.get (key);
	if (cached == null) {
	    cached = new Integer (key.uncachedEval ());
	    table.put (key, cached);
	}
	return cached.intValue ();
    }
}
