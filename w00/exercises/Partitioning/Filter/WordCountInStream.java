import java.io.IOException;

/**
 * Filter class to count the number of words read from an InStream
 */
public class WordCountInStream extends FilterInStream {
    // True if the previous character was a word separator
    private boolean previousSeparator = true;
    private long wordCount = 0;

    /**
     * Constructor
     * @param inStream The InStream that this object should delegate read
     * operations to.
     */
    public WordCountInStream(InStream inStream) throws IOException {
        super(inStream);
    } // Constructor(InStream)

    /**
     * Read words from a stream of words and fill an array with those words.
     * @param array The array of words to fill.
     * @exception IOException  if a I/O error occurs.
     */
    public int read(byte[] array) throws IOException {
        int count = super.read(array);
	for (int i = 0; i < count; i++) {
	    char myChar = (char) array [i];
	    boolean separator = Character.isWhitespace ((char) array [i]);
	    // count a word at the transition from a word-separator char
	    // to a non-word-separator char
	    if (previousSeparator && ! separator) wordCount++;
	    previousSeparator = separator;
	}
        return count;
    } // read(word[])

    /**
     * return the number of words that have been read by this object.
     */
    public long getWordCount() {
        return wordCount;
    } // getWordCount()
} // class WordCountInStream
