import java.io.InputStream;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.OutputStream;
import java.security.Key;

/**
 * class to RSA encrypt/decrypt streams of bytes.
 */
public class RSAEncryption extends Encryption {
    /**
     * Constructor
     * @param key The key to use to perform the encryption.
     */
     public RSAEncryption(Key key) {
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
        return new RSAEncrytpedOutputStream(out);
    } // encryptOutputStream(OutputStream)

    /**
     * This method returns an InputStream that decrypts the stream of
     * bytes that it reads from the given InputStream.
     * @param in The InputStream that the InputStream returned by this
     *           method will read bytes from.
     */
    InputStream decryptInputStream(InputStream in) {
        return new RSAEncrytpedInputStream(in);
    } // decryptInputStream(InputStream)

    /**
     * Class to encrypt an OuputStream.
     */
    private class RSAEncrytpedOutputStream extends FilterOutputStream {
        /**
         * constructor
         * @param out the OutputStream this object should write encrypted
         *            bytes to.
         */
        RSAEncrytpedOutputStream(OutputStream out) {
            super(out);
        } // RSAEncrytpedOutputStream(OutputStream)
        //...
    }  // class RSAEncrytpedOutputStream

    private class RSAEncrytpedInputStream extends FilterInputStream {
        /**
         * constructor
         * @param in the InputStream this object should read encrypted
         *            bytes from.
         */
        RSAEncrytpedInputStream(InputStream in) {
            super(in);
        } // RSAEncrytpedInputStream(InputStream)
        //...
    }  // class RSAEncrytpedInputStream
} // class RSAEncryption
