import java.io.PrintStream;

/**
 * Created by konstantin on 1/21/16.
 */
public class Variable implements Expr {
    String var;
    Variable(String var) { this.var = var; }
    Variable(Integer var) { this.var = var.toString();}
    public String toString() {
        return var;
    }

    public void pp(PrintStream out, int indent) {
        out.print(var);
    }
}
