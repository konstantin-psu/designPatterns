import java.io.IOException;

/**
 * Abstract class for reading a stream of bytes into an byte[].
 */
public abstract class InStream {
    /**
     * Read bytes and fill an array with those bytes.
     * @param array The array of bytes to fill.
     * @return If not enough bytes are available to fill the array then this
     *         method returns after having only put that many bytes in the
     *         array.  This methods returns -1 if the end of the data stream
     *         is encountered.
     * @exception IOException  if a I/O error occurs.
     */
    public abstract int read(byte[] array) throws IOException;
} // class InStream
