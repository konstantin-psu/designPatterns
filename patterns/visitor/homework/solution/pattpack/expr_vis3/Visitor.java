package pattpack.expr_vis3;

/**
 *  Visitor interface for expressions,
 *  <P>
 *  This interface defines a set of overloaded methods called <B>visit</B>.
 *  Each <B>visit</B> method has a similar signature described only
 *  once below.
 *  <UL>
 *  <LI> parameter <I>s</I> - A statment to be visited.
 *  <LI> parameter <I>o</I> - An object for the visit
 *                            (not necessarily used, may be null).
 *  <LI> return value - An object computed by the visit
 *                      (not necessarily used, may be null).
 */
 
public interface Visitor {
    public Object visit (Variable e, Object o);
    public Object visit (Add e, Object o);
    public Object visit (Sub e, Object o);
    public Object visit (Mul e, Object o);
    public Object visit (Div e, Object o);
    public Object visit (Gt e, Object o);
    public Object visit (Lt e, Object o);
}
