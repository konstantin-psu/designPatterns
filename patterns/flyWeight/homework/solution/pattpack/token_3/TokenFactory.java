package pattpack.token_3;

import java.io.*;

/**
 *  This class is a token factory for a simple language of expressions.
 *  Similar to an iterator, it enumerates all the tokens originating
 *  from a string.
 */

public class TokenFactory {
    private StreamTokenizer st;
    private Token token;
    /**
     *  Constructor of the token factory.
     *  @param source The string tokenize.
     *                The source could be a file too.
     *                Look at the comments in the code
     *                to see how to achieve this.
     */
    public TokenFactory (String source) {
//        To read from a file use next statement.
//        try {
//          Reader r = new BufferedReader (new FileReader (source));
            Reader r = new StringReader (source);
            st = new StreamTokenizer (r);
	    st.ordinaryChar ((char) '-');
	    st.ordinaryChar ((char) '/');
            readNextToken ();
//        } catch (FileNotFoundException fnf) {
//            System.err.println ("File not found");
//        }     
    }
    /**
     *  Tell whether the factory can create more tokens from the file.
     *  @return true if and only if the token being returned is EOF.
     */
    public boolean hasMoreTokens () { return ! (token instanceof EOF); }
    /**
     *  Create and return the next token of the file.
     *  @return The next token from the source.
     */
    public Token createToken () {
	Token tmp = token;
	readNextToken ();
	return tmp;
    }
    // This is the method that does the real work.
    // Gets the next token from the stream and
    // creates a corresponding Token object.
    private void readNextToken () {
        try {
            st.nextToken ();
            switch (st.ttype) {
            case st.TT_EOF: token = new EOF (); break;
            case st.TT_NUMBER: token = new Number (st.nval); break;
            case st.TT_WORD: token = new Identifier (st.sval); break;
            default: switch (st.ttype) {
		     // Could use a Flyweight for the following
                     case '(': token = new OpenParen (); break;
                     case ')': token = new CloseParen (); break;
                     case '+': token = new Add (); break;
                     case '-': token = new Sub (); break;
                     case '*': token = new Mul (); break;
                     case '/': token = new Div (); break;
         	     default: throw new RuntimeException (
                         "Unexpected character \"" + (char) st.ttype + "\"");
                     }
                break;
            }
        } catch (IOException ioe) {
            System.err.println ("IO Exception");
        }
    }
}
