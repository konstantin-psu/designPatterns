package pattpack.expr_vis3;

import java.io.*;

/**
 *  This class pretty prints an expression by means of a Visitor pattern.
 */

public class PrintVisitor implements Visitor {

    private PrintStream out;

    /**
     *  Construct this visitor.
     *  @param out  The stream where the program is printed.
     */
    public PrintVisitor (PrintStream out) { this.out = out; }

    // factor method for printing binary expressions
    private Object visit (String operator, Binary binary) {
	out.print (operator);
	out.print ("(");
	binary.getLeft ().accept (this, null);
	out.print (",");
	binary.getRight ().accept (this, null);
	out.print (")");
	return null;
    }

    /**
     *  Print an Add expression.
     *  @param o  Ignored
     *  @return Null
     */
    public Object visit (Add e, Object o) { return visit ("+", e); }
    /**
     *  Print an Sub expression.
     *  @param o  Ignored
     *  @return Null
     */
    public Object visit (Sub e, Object o) { return visit ("-", e); }
    /**
     *  Print an Mul expression.
     *  @param o  Ignored
     *  @return Null
     */
    public Object visit (Mul e, Object o) { return visit ("*", e); }
    /**
     *  Print an Div expression.
     *  @param o  Ignored
     *  @return Null
     */
    public Object visit (Div e, Object o) { return visit ("/", e); }
    /**
     *  Print an Gt expression.
     *  @param o  Ignored
     *  @return Null
     */
    public Object visit (Gt e, Object o) { return visit (">", e); }
    /**
     *  Print an Lt expression.
     *  @param o  Ignored
     *  @return Null
     */
    public Object visit (Lt e, Object o) { return visit ("<", e); }
    /**
     *  Print a variable expression.
     *  @param o  Ignored
     *  @return Null
     */
    public Object visit (Variable e, Object o) { 
	out.print (e.getName ());
	return null;
    }
}
