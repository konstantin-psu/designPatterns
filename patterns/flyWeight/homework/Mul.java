import java.io.PrintStream;

/**
 * Created by konstantin on 3/11/16.
 */
public class Mul implements Expr {
    Variable al;
    Variable ar;
    public Mul(Variable fact, Variable n) {
        al = fact; ar= n;
    }

    public void pp(PrintStream out, int indent) {
        al.pp(out,indent);
        out.print(" x ");
        ar.pp(out,indent);
    }
}
