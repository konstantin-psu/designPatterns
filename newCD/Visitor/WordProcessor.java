import java.util.Vector;

/**
 * This class contains the top level logic for a word processor
 */
public class WordProcessor {
    // The doucment currently being editied
    private Document activeDocument;

    //...
    /**
     * Reorganize a document into subfiles.
     */
    private void reorg(int level) {
        new ReorgVisitor(activeDocument, level);
    } // reorg

    /**
     * Build a table of contents
     */
    private TOC buildTOC() {
        return new TOCVisitor(activeDocument).buildTOC();
    } // buildTOC()
} // class WordProcessor
