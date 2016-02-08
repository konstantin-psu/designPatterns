import java.util.Vector;

/**
 * Instances of this class are composite objects that contain
 * DocumentElement objects.
 */
abstract class CompositeDocumentElement extends DocumentElement {
    // Collection of this object's children
    private Vector children = new Vector();

    // The cached value from the previous call to getCharLength or -1 to
    // indicate that charLength does not contain a cached value.
    private int cachedCharLength = -1;

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
            child.parent = this;
            changeNotification();
        } // synchronized
    } // addChild(DocumentElement)

    /**
     * Make the given DocumentElement NOT a child of this object.
     */
    public synchronized void removeChild(DocumentElement child) {
        synchronized (child) {
            if (this == child.parent)
              child.parent = null;
            children.removeElement(child);
            changeNotification();
        } // synchronized
    } // removeChild(DocumentElement)

    //...

    /**
     * A call to this method means that one of this object's children
     * has changed in a way that invalidates whatever data this object
     * may be cahcing about its children.
     */
    public void changeNotification() {
        cachedCharLength = -1;
        if (parent != null)
          parent.changeNotification();
    } // changeNotification()

    /**
     * Return the number of characters that this object contains.
     */
    public int getCharLength() {
        int len = 0;
        for (int i = 0; i < children.size(); i++) {
            len += ((DocumentElement)children.elementAt(i)).getCharLength();
        } // for
        cachedCharLength = len;
        return len;
    } // getCharLength()
} // class CompositeDocumentElement
