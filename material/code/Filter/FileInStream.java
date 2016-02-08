import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * This class reads a stream of bytes from a file.
 */
public class FileInStream extends InStream {
    private RandomAccessFile file;

    /**
     * Constructor
     * @param fName The name of the file to read
     */
    public FileInStream(String fName) throws IOException {
        file = new RandomAccessFile(fName, "r");
    } // Constructor(String)

    /**
     * Read bytes from a file and fill an array with those bytes.
     * @param array The array of bytes to fill.
     * @return If not enough bytes are available to fill the array then this
     *         method return after having only put that many bytes in the
     *         array.  This methods returns -1 if the end of the data stream
     *         is encountered.
     * @exception IOException  if a I/O error occurs.
     */
    public int read(byte[] array) throws IOException {
        return file.read(array);
    } // read(byte[])
} // class FileInStream
