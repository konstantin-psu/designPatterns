package pattpack.ast_vis2;

/**
 *  Visitor interface for Statements,
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

    public Object visit (Assignment s, Object o);
    public Object visit (Compound s, Object o);
    public Object visit (Conditional s, Object o);
    public Object visit (Output s, Object o);
    public Object visit (While s, Object o);

}
