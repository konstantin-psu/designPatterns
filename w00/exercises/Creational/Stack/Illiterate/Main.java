import java.util.*;

/**
 * This program constructs, fills, and prints a stack.
 * The type of stack and stack elements are hardwired.
 */

public class Main {
    /**
     * Program entry point.
     * @param arg Command line arguments, not used.
     */
    public static void main (String [] arg) { tester (); }
    /**
     * Construct a stack, push elements on it, print it.
     * It is static so it can be directly called by main.
     */
    private static void tester () {
	Stack stack = new Stack ();
	for (int i = 0; i < 30; i++)
	    stack.push (new Integer (i));
	System.out.println (stack);
    }
}
