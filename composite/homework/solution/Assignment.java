package pattpack.ast_1;

import java.io.*;

/**
 *  This class represents an assignment statement.
 */

public class Assignment extends Statement {
    private String lvalue;
    private Expr rvalue;
    /**
     *  Constructor, instances are immutable.
     *  @param lvalue The left-hand side of this assignment.
     *  @param rvalue The righ-hand side of this assignment.
     */
    public Assignment (String lvalue, Expr rvalue) {
	this.lvalue = lvalue;
	this.rvalue = rvalue;
    }
    /**
     *  Print this statement with indentation.
     *  @param out The stream where this statement is printed.
     *  @param indent The amount of indentation of this statement.
     */
    public void print (PrintStream out, int indent) {
	leaders (out, indent);
	out.print (lvalue);
	out.print (" := ");
	rvalue.print (out);
    }
}
