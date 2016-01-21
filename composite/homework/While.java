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
    void pp(int depth) {
        indent(depth);
        System.out.println("while "+cond+ " do");
        s.pp(depth+defaultIndent);

    }
}
