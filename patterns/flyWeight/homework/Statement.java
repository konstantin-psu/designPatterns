import java.io.PrintStream;

/**
 * Created by konstantin on 1/21/16.
 */
abstract public class Statement {
    int defaultIndent = 4;
    void indent(int depth) {
        for (int i = 0; i< depth; i++) {
            System.out.print(" ");
        }
    }
    abstract void pp(PrintStream out, int dept);
    //void pp(int dept) {}
}
