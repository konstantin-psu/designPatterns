import java.io.PrintStream;
import java.util.Vector;

/**
 * Created by konstantin on 1/21/16.
 */
public class Compound extends Statement {
    Vector<Statement> statements = new Vector<Statement>();

    Compound(Statement... args) {
        for (Statement s: args) {
            statements.add(s);
        }
    }
    void pp(PrintStream out, int depth) {
        indent(depth);
        out.println("begin");
        for(Statement s: statements) {
            s.pp(out, depth + defaultIndent);
        }
        indent(depth);
        out.println("end");

    }
}
