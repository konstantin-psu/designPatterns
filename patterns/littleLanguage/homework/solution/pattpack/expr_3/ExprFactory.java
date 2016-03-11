package pattpack.expr_3;

import pattpack.token_3.*;
import java.io.*;

/**
 *  This class is a expression factory for a simple language of expressions.
 *  It constructs a expressions from tokens using a recursive
 *  descendant (LL) parser.
 *  <P>
 *  The language is defined by the following syntax, where ZERO_OR_MORE
 *  is a metasymbol with the obvious meaning 
 *  <PRE>
 *  |   expr ::= addend ZERO_OR_MORE (("+" | "-") addend)
 *  |   addend ::= factor ZERO_OR_MORE (("*" | "/") factor)
 *  |   factor ::= number | "(" expr ")"
 *  </PRE>
 */

public class ExprFactory {
    private VarFactory vf = VarFactory.getInstance ();
    private TokenFactory tf;
    private Token token;
    /**
     *  Build an expression from a sequence of tokens.
     *  @param source The source for the tokens.
     *                Depending on TokenFactory it could be an expression
     *                or the name of a file containing an expression.
     *  @return The expressions constructed from the enumeration
     *          of tokens.
     */
    public Expr createExpr (String source) { 
	//	TokenFactory tokenFactory = new TokenFactory (source);
	//	while (tokenFactory.hasMoreTokens ()) {
	//	    Token token = tokenFactory.createToken ();
	//	    System.out.println (token);
	//	}
	this.tf = new TokenFactory (source);
	getNextToken ();
	Expr expr = NTexpr ();
	if (token instanceof pattpack.token_3.EOF) return expr;
	else throw new RuntimeException ("Unexpected token "+token);
    }

    private void getNextToken () { token = tf.createToken (); }

    private Expr NTexpr () {
	Expr left = NTaddend ();
	while (token instanceof pattpack.token_3.Add || token instanceof pattpack.token_3.Sub) {
	    Token saveOp = token;
	    getNextToken ();
	    Expr right = NTaddend ();
	    if (saveOp instanceof pattpack.token_3.Add) left = new Add (left, right);
	    else left = new Sub (left, right);
	}
	return left;
    }

    private Expr NTaddend () {
	Expr left = NTfactor ();
	while (token instanceof pattpack.token_3.Mul || token instanceof pattpack.token_3.Div) {
	    Token saveOp = token;
	    getNextToken ();
	    Expr right = NTfactor ();
	    if (saveOp instanceof pattpack.token_3.Mul) left = new Mul (left, right);
	    else left = new Div (left, right);
	}
	return left;
    } 

    private Expr NTfactor () {
	if (token instanceof pattpack.token_3.Number) {
	    Token save = token;
	    getNextToken ();
	    return vf.makeVar ((int) ((pattpack.token_3.Number) save).getValue ());
	} else if (token instanceof pattpack.token_3.Identifier) {
	    Token save = token;
	    getNextToken ();
	    return vf.makeVar (((pattpack.token_3.Identifier) save).getName ());
	} else if (token instanceof pattpack.token_3.OpenParen) {
	    getNextToken ();
	    Expr expr = NTexpr ();
	    if (token instanceof pattpack.token_3.CloseParen) {
		getNextToken ();
		return expr;
	    } else throw new RuntimeException (
                  "Missing right parenthesis before "+token);
	} else throw new RuntimeException ("Missing operand before "+token);
    }
}

