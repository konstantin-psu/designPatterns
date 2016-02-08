/**
 * Instances of this class encapsulate a string for inclusion in message
 * bodies. 
 */
class RichTextString implements RichText {
    private String text;

    /**
     * Constructor
     * @param text The string that this object adapts to the RichText
     *             interface.
     */
    public RichTextString(String text) {
        this.text = text;
        //...
    } // constructor(String)
    //...
} // class RichTextString
