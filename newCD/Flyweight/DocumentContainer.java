import java.awt.Font;
import java.util.Vector;

/**
 * Instances of this class are composite objects that contain
 * DocumentElement objects.
 */
abstract class DocumentContainer extends DocumentElement {
    // Collection of this object's children
    private Vector children = new Vector();

    // This is the font associated with this object.  If the font
    // variable is null, then this object's font will be inherited
    // through the container hierarchy from an enclosing object.
    private Font font;

    DocumentContainer parent; // this object's container

    /**
     * Return the child object of this object that is at the given
     * position.
     * @param index The index of the child.
     */
    public DocumentElement getChild(int index) {
        return (DocumentElement)children.elementAt(index);
    } // getChild(int)

    /**
     * Make the given DocumentElement a child of this object.
     */
    public synchronized void addChild(DocumentElement child) {
        synchronized (child) {
            children.addElement(child);
            if (child instanceof DocumentContainer)
              ((DocumentContainer)child).parent = this;
        } // synchronized
    } // addChild(DocumentElement)

    /**
     * Make the given DocumentElement NOT a child of this object.
     */
    public synchronized void removeChild(DocumentElement child) {
        synchronized (child) {
            if (child instanceof DocumentContainer
                && this == ((DocumentContainer)child).parent)
              ((DocumentContainer)child).parent = null;
            children.removeElement(child);
        } // synchronized
    } // removeChild(DocumentElement)

    /**
     * Return this object's parent or null if it has no parent.
     */
    public DocumentContainer getParent() {
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
    //...
} // class DocumentContainer
