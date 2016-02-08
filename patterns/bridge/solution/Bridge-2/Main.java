/**
 *  This class is a small client of a Bridge pattern
 *  The bridge concerns a stack tha dynamically changes implementation.
 *  The client pushes a few integers onto the stack.
 *  Supposedly, the stack overflows and silently changes implementation.
 *  Then, the client repeatedly pops the stack and prints the popped values.
 */
public class Main {
    /**
     *  Usual entry point.
     *  @param arg Ignored.
     */
    public static void main (String [] arg) {
	Stack stack = new Stack ();
	for (int i = 0; i < 20; i++)
	    stack.push (i);
	while (stack.size () > 0)
	    System.out.println (stack.pop ());
    }
}
