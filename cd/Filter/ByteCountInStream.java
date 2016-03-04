import java.io.IOException;

/**
 * Filter class to count the number of bytes read from an InStream
 */
public class ByteCountInStream extends FilterInStream {
    private long byteCount = 0;

    /**
     * Constructor
     * @param inStream The InStream that this object should delegate read
     * operations to.
     */
    public ByteCountInStream(InStream inStream) throws IOException {
        super(inStream);
    } // Constructor(InStream)

    /**
     * Read bytes from a stream of bytes and fill an array with those bytes.
     * @param array The array of bytes to fill.
     * @exception IOException  if a I/O error occurs.
     */
    public int read(byte[] array) throws IOException {
        int count;
        
        count = super.read(array);
        if (count >0)
          byteCount += count;
        return count;
    } // read(byte[])

    /**
     * return the number of bytes that have been read by this object.
     */
    public long getByteCount() {
        return byteCount;
    } // getByteCount()
} // class ByteCountInStream
