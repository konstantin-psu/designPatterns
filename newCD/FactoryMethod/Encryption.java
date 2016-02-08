import java.io.InputStream;
import java.io.OutputStream;
import java.security.Key;

/**
 * Abstract class to encrypt/decrypt streams of bytes.
 */
abstract public class Encryption {
    private Key key;

    /**
     * Constructor
     * @param key The key to use to perform the encryption.
     */
     public Encryption(Key key) {
         this.key = key;
     } // Constructor(Key)

    /**
     * Return the key this object used for encryption and decryption.
     */
    protected Key getKey() {
        return key;
    } // getKey()

    /**
     * This method returns an OutputStream that encrypts the bytes
     * written to it and writes the encrypted bytes to the given
     * OutputStream.
     * @param out The OutputStream that the OutputStream returned by
     *            this method will write encrypted bytes to.
     */
    abstract OutputStream encryptOutputStream(OutputStream out);

    /**
     * This method returns an InputStream that decrypts the stream of
     * bytes that it reads from the given InputStream.
     * @param in The InputStream that the InputStream returned by this
     *           method will read bytes from.
     */
    abstract InputStream decryptInputStream(InputStream in);
} // class Encrypt
