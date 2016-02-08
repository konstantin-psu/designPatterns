import java.util.Hashtable;

/**
 * Instances of this class build a table of contents
 */
class TOCVisitor extends DocumentVisitor {
    private Hashtable tocStyles = new Hashtable();

    TOCVisitor(Document document) {
        super(document);
        TocLevel[] levels = document.getTocLevels();
        // put styles in a hashtable.
        for (int i=0; i < levels.length; i++) {
            tocStyles.put(levels[i].getStyle(), levels[i]);
        } // for
    } // constructor(Document)

    TOC buildTOC() {
        TOC toc = new TOC();
        Paragraph p;
        while ((p = getNextParagraph()) != null) {
            String styleName = p.getStyle();
            if (styleName != null) {
                TocLevel level = (TocLevel)tocStyles.get(styleName);
                if (level != null) {
                    LineOfText firstLine = null;
                    for (int i = 0; i < p.getChildCount(); i++) {
                        DocumentElement e = p.getChild(i);
                        if (e instanceof LineOfText) {
                            firstLine = (LineOfText)e;
                            break;
                        } // if
                        //...
                    } // for
                } // if 
            } // if
        } // while
        return toc;
    } // buildTOC()
} // class TOCVisitor
