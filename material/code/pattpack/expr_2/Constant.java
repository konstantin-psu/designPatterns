package pattpack.expr_2;

/**
 *  This class implements constant expressions.
 *  A constant expression is the representation of an "int".
 */

public class Constant extends Expr {
    /**
     *  Construct this expression.
     *  @param value The int value represented by this expression.
     */
    public Constant (int value) { 
	cached = true;
	this.value = value; 
    }
    public int eval () { return value; }
}
