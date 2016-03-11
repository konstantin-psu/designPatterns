package pattpack.ast_3;

import pattpack.expr_3.*;
import java.io.*;

/**
 *  This class represents an assignment statement.
 */

public class Assignment extends Statement {
    private Variable lvalue;
    private Expr rvalue;
    /**
     *  Constructor, instances are immutable.
     *  @param lvalue The left-hand side of this assignment.
     *  @param rvalue The righ-hand side of this assignment.
     */
    public Assignment (Variable lvalue, Expr rvalue) {
	this.lvalue = lvalue;
	this.rvalue = rvalue;
    }
    /**
     *  Print this statement with indentation.
     *  @param out The stream where this statement is printed.
     *  @param indent The amount of indentation of this statement.
     */
    public void print (PrintStream out, int indent) {
	super.print (out, indent);
	lvalue.print (out);
	out.print (" := ");
	rvalue.print (out);
    }
    /**
     *  Interpret this statement.
     */
    public void interpret () { lvalue.setValue (rvalue.eval ()); }
}
