import java.io.PrintStream;

/**
 * Created by konstantin on 1/21/16.
 */
public interface Expr {
    void pp(PrintStream out, int indent);
}
