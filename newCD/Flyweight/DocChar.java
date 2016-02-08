/**
 * Instances of this class represent a character in a document.
 */
class DocChar extends DocumentElement {
    private char character;

    /**
     * Constructor
     * @param c the character that this object represents.
     */
    DocChar (char c) {
        character = c;
    } // Constructor(char)

    //...
    /**
     * Return the character that this object represents
     */
    public char getChar() {
        return character;
    } // getChar()

    /**
     * This method returns a unique value that determines where it is stored
     * internally in a hash table.
     */
    public int hashCode() {
        return getChar();
    } // hashCode()

    /**
     * Redefine equals so that two DocChar objects are considered
     * equal if they represent the same character.
     */
    public boolean equals(Object o) {
        // Call getChar rather than access character directly so that
        // this method will any alternate way a subclass has of
        // providing the character it represents.
        return (o instanceof DocChar
                && ((DocChar)o).getChar() == getChar());
    } // equals(Object)
} // class DocChar
