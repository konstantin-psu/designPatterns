/**
 * Created by konstantin on 1/21/16.
 */
public class Assignment extends Statement {
    Var lhs;
    Expr rhs;
    Assignment(Var var, Expr expr) {
        this.lhs = var;
        this.rhs = expr;
    }

    void pp(int depth) {
        indent(depth);
        System.out.println(lhs + " := " + rhs);
    }
}
