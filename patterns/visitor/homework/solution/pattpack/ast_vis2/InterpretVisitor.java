package pattpack.ast_vis2;

import java.io.*;

/**
 *  This class interprets a program by means of a Visitor pattern.
 */

public class InterpretVisitor implements Visitor {

    /**
     *  Interpret an Assignment statement.
     *  @param o  Ignored
     *  @return Null
     */
    public Object visit (Assignment s, Object o) {
	s.getLvalue ().setValue (s.getRvalue ().eval ());
	return null;
    }
    /**
     *  Interpret an Compound statement.
     *  @param o  Ignored
     *  @return Null
     */
    public Object visit (Compound s, Object o) {
	Statement [] body = s.getBody ();
	for (int i = 0; i < body.length; i++) body [i].accept (this, o);
	return null;
    }
    /**
     *  Interpret an Conditional statement.
     *  @param o  Ignored
     *  @return Null
     */
    public Object visit (Conditional s, Object o) {
	if (s.getTest ().eval () == 1)
	    s.getThenClause ().accept (this, o);
	else
	    s.getElseClause ().accept (this, o);
	return null;
    }
    /**
     *  Interpret an Output statement.
     *  @param o  Ignored
     *  @return Null
     */
    public Object visit (Output s, Object o) {
	System.out.println (s.getExpr ().eval ());
	return null;
    }
    /**
     *  Interpret an While statement.
     *  @param o  Ignored
     *  @return Null
     */
    public Object visit (While s, Object o) {
	while (s.getTest ().eval () == 1) s.getBody ().accept (this, o);
	return null;
    }
} 
