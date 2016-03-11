package pattpack.expr_vis3;

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
     *  Set the value of this variable.
     *  @param value  The value to set this variable to.
     */
    public void setValue (int value) { this.value = value; }
    /**
     *  Get the value of this variable.
     *  @return  The value of this variable.
     */
    public int getValue () { return value; }
    /**
     *  Get the name of this variable.
     *  @return  The name of this variable.
     */
    public String getName () { return name; }
    /**
     *  Visitor dispatcher.
     *  @param visitor The visitor to visit this object.
     *  @param data The visitor argument.
     *  @return The visitor returned value.
     */
    public Object accept (Visitor visitor, Object data) {
	return visitor.visit (this, data);
    }
}
