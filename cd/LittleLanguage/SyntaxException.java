/**
 * The parser throws an instance of this class if it encounters a syntax
 * Exception.
 */
public class SyntaxException extends Exception {
    public SyntaxException() {}

    public SyntaxException(String msg) {
        super(msg);
    } // constructor(String)
} // 
