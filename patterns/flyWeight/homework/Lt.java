import java.io.PrintStream;

/**
 * Created by konstantin on 3/11/16.
 */
public class Lt implements Expr {
    Expr left;
    Expr right;
    int counter;
    Lt(Expr l, Expr r) {
        left = l;
        right = r;
        counter++;
    }

    public void pp(PrintStream out, int indent) {
        out.print("(");
        left.pp(out, indent);
        out.print(" < ");
        right.pp(out, indent);
        out.print(")");
    }
}
