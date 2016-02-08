import java.awt.Font;

/**
 * All elements of a document belong to a subclass of this abstract class.
 */
abstract class DocumentElement {
    // This is the font associated with this object.  If the font
    // variable is null, then this object's font will be inherited
    // through the container hierarchy from an enclosing object.
    private Font font;

    CompositeDocumentElement parent; // this object's container

    //...

    /**
     * Return this object's parent or null if it has no parent.
     */
    public CompositeDocumentElement getParent() {
        return parent;
    } // getParent()

    /**
     * Return the Font associatiated with this object.  If there is no
     * Font associated with this object, then return the Font associated
     * with this object's parent. If there is no Font associated
     * with this object's parent the return null.
     */
    public Font getFont() {
        if (font != null)
          return font;
        else if (parent != null)
          return parent.getFont();
        else
          return null;
    } // getFont()

    /**
     * Associate a Font with this object.
     * @param font The font to associate with this object
     */
    public void setFont(Font font) {
        this.font = font;
    } // setFont(Font)

    /**
     * Return the number of characters that this object contains.
     */
    public abstract int getCharLength() ;
} // class DocumentElement 
