import ast.*;
import expr.*;
import java.io.*;

/**
 *  Driver for a Composite pattern example.
 *  Composite objects are programs in a simple "while" language
 *  defined by the following syntax:
 *  <PRE>
        Statement   ::= Assignment | Conditional | While | Compound
        Assignment  ::= Var = Expr
        Conditional ::= if Expr then Statement else Statement
        While       ::= while Expr do Statement
        Compound    ::= begin Statement; ...; Statement end
 *  </PRE>
 *  The main method constructs and pretty prints the following
 *  program
 *  <PRE>
        begin
          fact = 1;
          while (n > 1) do
            begin
              fact := fact * n;
              n := n - 1
            end
        end
 *  </PRE>
 */
public class Main {
    /** Usual entry point. Constructs and pretty prints an example program. */
    public static void main (String [] arg) {
	VarFactory vf = VarFactory.getInstance ();
	Statement factorial = new Compound (
	    new Assignment (vf.makeVar ("fact"), vf.makeVar ("1")),
	    new While (new Gt (vf.makeVar ("n"),
			       vf.makeVar ("1")), new Compound (
      	        new Assignment (vf.makeVar ("fact"),
				new Mul (vf.makeVar ("fact"),
					 vf.makeVar ("n"))),
	        new Assignment (vf.makeVar ("n"),
				new Sub (vf.makeVar ("n"),
					 vf.makeVar ("1"))))));
	factorial.print (System.out, 0);
	System.out.println ();
    }
}
