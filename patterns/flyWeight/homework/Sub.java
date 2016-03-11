import java.io.PrintStream;

/**
 * Created by konstantin on 3/11/16.
 */
public class Sub implements Expr {
    Variable al;
    Variable ar;
    public Sub(Variable fact, Variable n) {
        al = fact; ar= n;
    }

    public void pp(PrintStream out, int indent) {
        al.pp(out,indent);
        out.print(" - ");
        ar.pp(out,indent);
    }
}
