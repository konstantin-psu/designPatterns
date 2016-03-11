import java.io.PrintStream;

/**
 * Created by konstantin on 1/21/16.
 */
public class Conditional extends Statement {
    Expr e;
    Statement trueCase;
    Statement falseCase;
    Conditional(Expr e, Statement s1, Statement s2) {
        this.e = e;
        trueCase = s1;
        falseCase = s2;
    }

    void pp(PrintStream out, int depth) {
        indent(depth);
        out.println("if "+e +" then:");
        trueCase.pp(out, depth+defaultIndent);
        out.println("else:");
        falseCase.pp(out, depth+defaultIndent);
    }
}
