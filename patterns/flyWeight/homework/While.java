import java.io.PrintStream;

/**
 * Created by konstantin on 1/21/16.
 */
public class While extends Statement {
    Expr cond;
    Statement s;
    While(Expr e, Statement s) {
        this.cond = e;
        this.s = s;
    }
    void pp(PrintStream out, int depth) {
        indent(depth);
        out.print("while ");
        cond.pp(out, depth);
        out.print( " do\n");
        s.pp(out, depth+defaultIndent);

    }
}
