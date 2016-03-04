import java.io.InputStream;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.OutputStream;
import java.security.Key;

/**
 * class to DES encrypt/decrypt streams of bytes.
 */
public class DESEncryption extends Encryption {
    /**
     * Constructor
     * @param key The key to use to perform the encryption.
     */
     public DESEncryption(Key key) {
         super(key);
     } // Constructor(Key)

    /**
     * This method returns an OutputStream that encrypts the bytes
     * written to it and writes the encrypted bytes to the given
     * OutputStream.
     * @param out The OutputStream that the OutputStream returned by
     *            this method will write encrypted bytes to.
     */
    OutputStream encryptOutputStream(OutputStream out) {
        return new DESEncrytpedOutputStream(out);
    } // encryptOutputStream(OutputStream)

    /**
     * This method returns an InputStream that decrypts the stream of
     * bytes that it reads from the given InputStream.
     * @param in The InputStream that the InputStream returned by this
     *           method will read bytes from.
     */
    InputStream decryptInputStream(InputStream in) {
        return new DESEncrytpedInputStream(in);
    } // decryptInputStream(InputStream)

    /**
     * Class to encrypt an OuputStream.
     */
    private class DESEncrytpedOutputStream extends FilterOutputStream {
        /**
         * constructor
         * @param out the OutputStream this object should write encrypted
         *            bytes to.
         */
        DESEncrytpedOutputStream(OutputStream out) {
            super(out);
        } // DESEncrytpedOutputStream(OutputStream)
        //...
    }  // class DESEncrytpedOutputStream

    private class DESEncrytpedInputStream extends FilterInputStream {
        /**
         * constructor
         * @param in the InputStream this object should read encrypted
         *            bytes from.
         */
        DESEncrytpedInputStream(InputStream in) {
            super(in);
        } // DESEncrytpedInputStream(InputStream)
        //...
    }  // class DESEncrytpedInputStream
} // class DESEncryption
