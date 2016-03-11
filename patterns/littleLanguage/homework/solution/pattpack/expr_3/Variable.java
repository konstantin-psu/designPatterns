package pattpack.expr_3;

import java.io.*;

/**
 *  This class represents a variable in an expression.
 *  A variable holds its current value under the assumption
 *  (Flyweight pattern) that all occurrences of a same
 *  variable are shared.  This is a crucial assumption for
 *  interpreting the statements that host a variable.
 */
public class Variable implements Expr {
    private String name;
    private int value;
    /**
     *  Construct a variable.
     *  @param name The identifier of this variable.
     */
    public Variable (String name) { this (name, 0); }
    /**
     *  Construct a variable.
     *  @param name The identifier of this variable.
     *  @param value The initializer of this variable.
     */
    public Variable (String name, int value) {
	this.name = name;
	this.value = value;
    }
    /**
     *  Print this expression.
     *  @param out The stream where the expression is printed.
     */
    public void print (PrintStream out) { out.print (name); }
    /**
     *  Set the value of this variable.
     *  @param value  The value to set this variable to.
     */
    public void setValue (int value) { this.value = value; }
    /**
     *  Return the value of this variable.
     *  @return The value of this variable.
     */
    public int eval () { return value; }
}
