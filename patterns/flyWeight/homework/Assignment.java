import java.io.PrintStream;

/**
 * Created by konstantin on 1/21/16.
 */
public class Assignment extends Statement {
    Variable lhs;
    Expr rhs;
    Assignment(Variable variable, Expr expr) {
        this.lhs = variable;
        this.rhs = expr;
    }

    void pp(PrintStream out, int depth) {
        indent(depth);
        lhs.pp(out, depth);
        out.print(" := ");
        rhs.pp(out, depth);
        out.println("");
    }
}
