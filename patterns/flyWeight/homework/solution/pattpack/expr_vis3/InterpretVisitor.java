package pattpack.expr_vis3;

/**
 *  This class interprets an expression by means of a Visitor pattern.
 */

public class InterpretVisitor implements Visitor {

    /**
     *  Interpret an Add expression.
     *  @param o  Ignored
     *  @return The value of the expression.
     */
    public Object visit (Add e, Object o) {
	int left = ((Integer) e.getLeft ().accept (this, o)).intValue ();
	int right = ((Integer) e.getRight ().accept (this, o)).intValue ();
	return new Integer (left+right);
    }
    /**
     *  Interpret an Sub expression.
     *  @param o  Ignored
     *  @return The value of the expression.
     */
    public Object visit (Sub e, Object o) {
	int left = ((Integer) e.getLeft ().accept (this, o)).intValue ();
	int right = ((Integer) e.getRight ().accept (this, o)).intValue ();
	return new Integer (left-right);
    }
    /**
     *  Interpret an Mul expression.
     *  @param o  Ignored
     *  @return The value of the expression.
     */
    public Object visit (Mul e, Object o) {
	int left = ((Integer) e.getLeft ().accept (this, o)).intValue ();
	int right = ((Integer) e.getRight ().accept (this, o)).intValue ();
	return new Integer (left*right);
    }
    /**
     *  Interpret an Div expression.
     *  @param o  Ignored
     *  @return The value of the expression.
     */
    public Object visit (Div e, Object o) {
	int left = ((Integer) e.getLeft ().accept (this, o)).intValue ();
	int right = ((Integer) e.getRight ().accept (this, o)).intValue ();
	return new Integer (left/right);
    }
    /**
     *  Interpret an Gt expression.
     *  @param o  Ignored
     *  @return The value of the expression.
     */
    public Object visit (Gt e, Object o) {
	int left = ((Integer) e.getLeft ().accept (this, o)).intValue ();
	int right = ((Integer) e.getRight ().accept (this, o)).intValue ();
	if (left > right) return new Integer (1);
	else return new Integer (0);
    }
    /**
     *  Interpret an Lt expression.
     *  @param o  Ignored
     *  @return The value of the expression.
     */
    public Object visit (Lt e, Object o) {
	int left = ((Integer) e.getLeft ().accept (this, o)).intValue ();
	int right = ((Integer) e.getRight ().accept (this, o)).intValue ();
	if (left < right) return new Integer (1);
	else return new Integer (0);
    }
    /**
     *  Interpret a variable expression.
     *  @param o  Ignored
     *  @return The value of the expression.
     */
    public Object visit (Variable e, Object o) {
	return new Integer (e.getValue ());
    }
} 
