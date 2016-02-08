/**
 * Instances of this class represent a document in a word processor.
 */
class Document {
    //...
    /**
     * Insert a string into this document at the given postion.
     * @param position Insert the string before this position.
     * @param strng the string to insert into this document
     */
    void insertStringCommand(int position, String strng) {
        //...
    } // insertStringCommand(int, String)

    /**
     * Delete the given number of character at the given position from
     * this document.
     * @param position The position to delete characters at.
     * @param length The number of characters to delete.
     */
    void deleteCommand(int position, int length) {
        //...
    } // deleteCommand(int, int)

    /**
     * Return the string contained in this document starting at the
     * given position and containing the given numbers of characters.
     * @param position the position in the document that the sequence of
     *                 characters to be retured begins at.
     * @param length The number of characters in the string to be
     *               returned. 
     */
    String getString(int position, int length) {
        String s = "";
        //...
        return s;
    } // getString(int, int)
} // class Document
