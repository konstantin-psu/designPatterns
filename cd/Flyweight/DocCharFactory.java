import java.util.Hashtable;

/**
 * Instances of this class are responsible for managing instances of the
 * DocChar class.
 */
class DocCharFactory {
    private MutableDocChar myChar = new MutableDocChar();

    /**
     * This is being written before the release of Java 1.2.  The
     * preliminary API documentation for Java 1.2, which is available
     * at this time but subject to change, documents a class called
     * javal.util.HashSet that will be more appropriate to use in this
     * class than java.util.Hashtable.
     */
    private Hashtable docCharPool = new Hashtable();

    /**
     * Return a DocChar object that represents the given character.
     * @param c The character to be represented.
     */
    DocChar getDocChar(char c) {
        myChar.setChar(c);
        DocChar thisChar = (DocChar)docCharPool.get(myChar);
        if (thisChar == null) {
            thisChar = new DocChar(c);
            docCharPool.put(thisChar, thisChar);
        } // if
        return thisChar;
    } // getDocChar(char)

    /**
     * To allow lookups of DocChar objects in a Hashtable or simillar
     * collection, we will need a DocChar object that represents the
     * same character as the DocChar object we want to find in the
     * collection.  Creating a DocChar object to perform each lookup
     * would largely defeat the purpose of putting the DocChar objects
     * into the collection.  That purpose is to avoid creating a
     * DocChar object for each character to be represented and instead
     * use one DocChar object to represent every occurence of a
     * character.
     *<p>
     * An alternative to creatning a DocChar object for each lookup is
     * to reuse the same DocChar object, changing the character that
     * it represents for each lookup.  The problem with wanting to
     * change the character that a DocChar object represents is that
     * DocChar objects are immutable.  There is no way to change the
     * character that a DocChar object represents.
     *<p>
     * A way to get around that problem it by using this private
     * subclass of DocChar that does provide a way to change the
     * character it represents.
     */
    private class MutableDocChar extends DocChar {
        private char character;

        /**
         * Constructor
         */
        MutableDocChar() {
            super('\u0000');    // It doesn't matter what we pass to super.
        } // Constructor(char)

        /**
         * Return the character that this object represents.
         */
        public char getChar() {
            return character;
        } // getChar()

        /**
         * Set the character that this object represents.
         * @param c The character that this object will represent.
         */
        public void setChar(char c) {
            character = c;
        } // setChar(char)
    } // class MutableDocChar
} // class DocCharFactory
