/**
 * Created by konstantin on 1/21/16.
 */
public class Client {
    public static void  main(String[] Ignore) {
//        Statement factorial = new Compound (
//                new Assignment (new Variable("fact"), new Gt(new Variable("n"), new Variable(1))),
//                new While (new Gt (new Variable("n"), new Variable(1)), new Compound(
//                        new Assignment (new Variable("fact"), new Gt(new Variable("n"), new Variable(1))),
//                        new Assignment (new Variable("n"), new Gt(new Variable("n"), new Variable(1))))));
        Statement factorial = new Compound (
                new Assignment (new Variable ("fact"), new Variable ("1")),
                new While (new Gt (new Variable ("n"),
                        new Variable ("1")), new Compound (
                        new Assignment (new Variable ("fact"),
                                new Mul (new Variable ("fact"),
                                        new Variable ("n"))),
                        new Assignment (new Variable ("n"),
                                new Sub (new Variable ("n"),
                                        new Variable ("1"))))));
        factorial.pp(System.out, 0);
    }
}
