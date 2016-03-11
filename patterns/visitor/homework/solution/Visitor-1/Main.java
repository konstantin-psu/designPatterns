import pattpack.ast_vis1.*;
import pattpack.expr_vis1.*;
import java.io.*;

/**
    Driver for an Interpreter pattern example.
    This example refines and extends the Flyweight example,
    which in turn refined and extends the Composite example.
    It uses Singleton and Immutable patterns too.
    <PRE>
    |    Statement   ::= Assignment | Conditional | While | Compound | Output
    |    Assignment  ::= Var = Expr
    |    Conditional ::= if Expr then Statement else Statement
    |    While       ::= while Expr do Statement
    |    Compound    ::= begin Statement; ...; Statement end
    |    Output      ::= output Expr
    </PRE>
    The main method constructs the following program:
    <PRE>
    |    begin
    |      n = 5;
    |      output (n);
    |      fact = 1;
    |      while (n > 1) do
    |        begin
    |          fact := fact * n;
    |          n := n - 1
    |        end;
    |      output (fact)
    |    end
    </PRE>
    It then interprets and/or pretty prints it.
 */
public class Main {
    /** 
     *  Usual entry point.
     *  Constructs an example program.
     *  Interpret and/or pretty print the example program.
     */
    public static void main (String [] arg) {
	VarFactory vf = VarFactory.getInstance ();
	Compound factorial = new Compound ( 
	    new Statement [] {
		new Assignment (vf.makeVar ("n"), vf.makeVar (6)),
		new Output (vf.makeVar ("n")),
		new Assignment (vf.makeVar ("fact"), vf.makeVar (1)),
		new While (
		    new Gt (vf.makeVar ("n"), vf.makeVar (1)),
			new Compound (
			    new Assignment (vf.makeVar ("fact"),
					    new Mul (vf.makeVar ("fact"),
						     vf.makeVar ("n"))),
			    new Assignment (vf.makeVar ("n"),
					    new Sub (vf.makeVar ("n"),
						     vf.makeVar (1))))),
		new Output (vf.makeVar ("fact")), });
	PrintVisitor pv = new PrintVisitor (System.out);
	pv.visit (factorial, new Integer (0));
	System.out.println ();
	//	factorial.interpret ();
    }
}
