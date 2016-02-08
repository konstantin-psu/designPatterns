package pattpack.ast_vis1;

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

    Object visit (Assignment s, Object o);
    Object visit (Compound s, Object o);
    Object visit (Conditional s, Object o);
    Object visit (Output s, Object o);
    Object visit (While s, Object o);

}
