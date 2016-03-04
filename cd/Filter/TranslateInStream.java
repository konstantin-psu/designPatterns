import java.io.IOException;

/**
 * Filter class to perform eight bit character translation.
 *<p>
 * This class treats the bytes in a bytes stream as eight bit character
 * codes and translates them to other character codes using a
 * translation table.
 */
public class TranslateInStream extends FilterInStream {
    private byte[] translationTable;
    private final static int TRANS_TBL_LENGTH = 256;

    /**
     * Constructor
     * @param inStream The InStream that this object should delegate read
     *                  operations to.
     * @param table An array of bytes that is used to
     *        determine translation values for character codes.
     *        The value to replace charactr code n with is found in at
     *        index n of the translation table.  If the array is longer
     *        than TRANS_TBL_LENGTH elements, the additional elements are
     *        ignored.  If the array is shorter than TRANS_TBL_LENGTH
     *        elements, then no translation is done on character codes
     *        greater than or equal to the length of the array.
     */
    public TranslateInStream(InStream inStream,
                             byte[] table) throws IOException {
        super(inStream);

        // Create translation table by copying translation data.
        translationTable = new byte[TRANS_TBL_LENGTH];
        System.arraycopy(table, 0, translationTable, 0,
                         Math.min(TRANS_TBL_LENGTH, table.length));
        for (int i = table.length; i < TRANS_TBL_LENGTH; i++) {
            translationTable[i] = (byte)i;
        } // for
    } // Constructor(InStream)

    /**
     * Read bytes from a stream of bytes and fill an array with those bytes.
     * @param array The array of bytes to fill.
     * @exception IOException  if a I/O error occurs.
     */
    public int read(byte[] array) throws IOException {
        int count;
        
        count = super.read(array);
        for (int i = 0; i < count; i++) {
            array[i] = translationTable[array[i]];
        } // for
        return count;
    } // read(byte[])
} // class ByteCountInStream
