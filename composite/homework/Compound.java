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
    void pp(int depth) {
        indent(depth);
        System.out.println("begin");
        for(Statement s: statements) {
            s.pp(depth + defaultIndent);
        }
        indent(depth);
        System.out.println("end");

    }
}
