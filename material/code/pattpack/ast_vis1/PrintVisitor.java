package pattpack.ast_vis1;

import java.io.*;

/**
 *  This class pretty prints program by means of a Visitor pattern.
 */

public class PrintVisitor implements Visitor {

    private PrintStream out;

    /**
     *  Construct this visitor.
     *  @param out  The stream where the program is printed.
     */
    public PrintVisitor (PrintStream out) { this.out = out; }

    private void indent (int indent) {
	out.println ();
	for (int i = 0; i < indent; i++) out.print ("  ");
    }

    /**
     *  Print an Assignment statement.
     *  @param o  A java.lang.Integer defining the indentation.
     *  @return Null
     */
    public Object visit (Assignment s, Object o) {
	int indent = ((Integer) o).intValue ();
	indent (indent);
	s.getLvalue ().print (out);
	out.print (" := ");
	s.getRvalue ().print (out);
	return null;
    }
    /**
     *  Print an Compound statement.
     *  @param o  A java.lang.Integer defining the indentation.
     *  @return Null
     */
    public Object visit (Compound s, Object o) {
	int indent = ((Integer) o).intValue ();
	indent (indent);
	out.print ("begin");
	Statement [] body = s.getBody ();
	for (int i = 0; i < body.length; i++) {
	    body [i].accept (this, new Integer (indent+1));
	    if (i < body.length-1) out.print (";");
	}
	indent (indent);
	out.print ("end");
	return null;
    }
    /**
     *  Print an Conditional statement.
     *  @param o  A java.lang.Integer defining the indentation.
     *  @return Null
     */
    public Object visit (Conditional s, Object o) {
	int indent = ((Integer) o).intValue ();
	indent (indent);
	out.print ("if ");
	s.getTest ().print (out);
	Integer indent2 = new Integer (indent+2);
	indent (indent+1);
	out.print ("then");
	Statement thenClause = s.getThenClause ();
	thenClause.accept (this, indent2);
	indent (indent+1);
	out.print ("else");
	Statement elseClause = s.getElseClause ();
	elseClause.accept (this, indent2);
	return null;
    }
    /**
     *  Print an Output statement.
     *  @param o  A java.lang.Integer defining the indentation.
     *  @return Null
     */
    public Object visit (Output s, Object o) {
	int indent = ((Integer) o).intValue ();
	indent (indent);
	out.print ("output (");
	s.getExpr ().print (out);
	out.print (")");
	return null;
    }
    /**
     *  Print an While statement.
     *  @param o  A java.lang.Integer defining the indentation.
     *  @return Null
     */
    public Object visit (While s, Object o) {
	int indent = ((Integer) o).intValue ();
	indent (indent);
	out.print ("while ");
	s.getTest ().print (out);
	out.print (" do");
	Statement body = s.getBody ();
	body.accept (this, new Integer (indent+1));
	return null;
    }
} 
