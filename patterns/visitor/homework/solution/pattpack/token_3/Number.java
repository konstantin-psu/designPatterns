package pattpack.token_3;

/**
 *  Representation of number tokens.
 */
public class Number extends Token {
    private double value;
    /**
     *  Construct a token from its name.
     *  @param name The identifier that yields the token.
     */
    public Number (double value) { this.value = value; }
    /**
     *  Return the value of this token.
     *  @return The value of this token.
     */
    public double getValue () { return value; }
    /**
     *  Return a printable representation of this token.
     *  @return A printable representation of this token.
     */
    public String toString () { return "Number "+value; }
}
