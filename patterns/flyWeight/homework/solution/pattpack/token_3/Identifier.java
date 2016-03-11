package pattpack.token_3;

/**
 *  Representation of identifier tokens.
 */
public class Identifier extends Token {
    private String name;
    /**
     *  Construct a token from its name.
     *  @param name The identifier that yields the token.
     */
    public Identifier (String name) { this.name = name; }
    /**
     *  Return the identifier of this token.
     *  @return The identifier of this token.
     */
    public String getName () { return name; }
    /**
     *  Return a printable representation of this token.
     *  @return A printable representation of this token.
     */
    public String toString () { return "Identifier "+name; }
}
