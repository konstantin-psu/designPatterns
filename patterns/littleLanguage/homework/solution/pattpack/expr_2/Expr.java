package pattpack.expr_2;

import java.util.*;

/**
 *  This class defines the methods available in every expression.
 *  It also serves as a cache manager of the expression's value.
 */
public abstract class Expr {
    /** The cache of this expression's value. */
    protected boolean cached = false;
    protected int value;
    /**
     *  Evaluate this expressions.
     *  This method fetches the cached value of this expression,
     *  if it is available.  Otherwise, compute the value
     *  and cache it for later opportunities.
     *  @return The value of this expression.
     */
    public abstract int eval ();
}