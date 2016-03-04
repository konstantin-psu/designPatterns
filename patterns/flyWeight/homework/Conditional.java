/**
 * Created by konstantin on 1/21/16.
 */
public class Conditional extends Statement {
    Expr e;
    Statement trueCase;
    Statement falseCase;
    Conditional(Expr e, Statement s1, Statement s2) {
        this.e = e;
        trueCase = s1;
        falseCase = s2;
    }

    void pp(int depth) {
        indent(depth);
        System.out.println("if "+e +" then:");
        trueCase.pp(depth+defaultIndent);
        System.out.println("else:");
        falseCase.pp(depth+defaultIndent);
    }
}
