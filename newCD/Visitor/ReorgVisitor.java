/**
 * Instances of this class reorganize a document into multiple documents.
 */
class ReorgVisitor extends DocumentVisitor {
    private TocLevel[] levels;

    ReorgVisitor(Document document, int level) {
        super(document);
        this.levels = document.getTocLevels();
        Paragraph p;
        while ((p = getNextParagraph()) != null) {
            //...
        } // while
    } // constructor(Document)
} // class ReorgVisitor

