/**
 * Created by konstantin on 1/21/16.
 */
public class Client {
    public static void  main(String[] Ignore) {
        Statement factorial = new Compound (
                new Assignment (new Var("fact"), new Expr ()),
                new While (new Expr (), new Compound(
                        new Assignment (new Var("fact"), new Expr ()),
                        new Assignment (new Var("n"), new Expr ()))));
        factorial.pp(0);
    }
}
