package pattpack.expr_extr;

import java.io.*;

/**
 *  This class represents a variable in an expression.
 *  Together with the variable identifier, the source code line
 *  of this variable occurrence is stored.
 *  For the purpose of this exercise, literals can be considered as variables.
 */
public class VarWithLine implements Variable {
    private Variable variable;
    private int line;
    /**
     *  Construct a variable.
     *  @param name The pure variable part of this variable with line.
     *  @param line The source code line of this variable occurrence.
     */
    /* public */ VarWithLine (Variable variable, int line) { 
	this.variable = variable;
	this.line = line;
    }
    /**
     *  Print this expression.
     *  @param out The stream where the expression is printed.
     */
    public void print (PrintStream out) { 
	variable.print (out);
	out.print ("_");
	out.print (line);
    }
}
