/**
 * Instances of this class represent a document.
 */
class Document extends CompositeDocumentElement {
    private String fname;
    private TocLevel[] levels = new TocLevel[0];
    //...
    /**
     * Return the name of the file this document is stored in.
     */
    public String getFileName() {
        return fname;
    } // getFileName()

    /**
     * Return an array of TocLevel objects.
     */
    TocLevel[] getTocLevels() {
        TocLevel[] myLevels = new TocLevel[levels.length];
        System.arraycopy(levels, 0, myLevels, 0, levels.length);
        return levels;
    }
    //...
} // class Document
