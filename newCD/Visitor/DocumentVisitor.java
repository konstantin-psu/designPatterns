/**
 * Superclass for classes that visit objects that make up a document and
 * manipulate them.
 */
abstract class DocumentVisitor {
    private Document document;
    private int docIndex = 0;   // This index used to navigate children
                                // of document.
    /**
     * Constructor.
     * @param document The Document to be visited.
     */
    DocumentVisitor(Document document) {
        this.document = document;
    } // constructor(Document)

    /**
     * return the document that this object is manipulating
     */
    protected Document getDocument() { return document; }

    /**
     * Return the next paragraph that is a direct part of the document
     * being manipulated or null of there is no next paragraph.
     */
    protected Paragraph getNextParagraph() {
        Document myDocument = document;
        while (docIndex < myDocument.getChildCount()) {
            DocumentElement docElement;
            docElement = myDocument.getChild(docIndex);
            docIndex += 1;
            if (docElement instanceof Paragraph)
              return (Paragraph)docElement;
        }
        return null;
    } // getNextParagraph()
    //...
} // class DocumentVisitor
