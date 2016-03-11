package pattpack.expr_extr;

import java.io.*;

/**
 *  This class represents a variable in an expression.
 *  For the purpose of this exercise, literals can be considered as variables.
 */
public class SimpleVar implements Variable {
    private String name;
    /**
     *  Construct a variable.
     *  @param name The identifier of this variable.
     */
    public SimpleVar (String name) { this.name = name; }
    /**
     *  Print this expression.
     *  @param out The stream where the expression is printed.
     */
    public void print (PrintStream out) { out.print (name); }
}
