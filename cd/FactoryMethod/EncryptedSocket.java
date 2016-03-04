import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

/**
 * This class extends socket so that the stream of bytes that goes over
 * the net is encrypted.
 */
public class EncryptedSocket extends Socket {
    private static Encryption crypt;
    private Key key;

    /**
     * Constructor
     * @param key The key to use for encryption and decryption.  This
     *            object will determine the encryption technique to use
     *            by calling the key object's getAlgorithm() method.
     * @param factory The Factory object to use to create Encryption
     *                objects.
     * @exception NoSuchAlgorithmException if the key specifies an
     *            encryption technique that is not available.
     */
    public EncryptedSocket(Key key, EncryptionFactoryIF factory) throws NoSuchAlgorithmException {
        this.key = key;
        crypt = factory.createEncryption(key);
    } // Constructor(Key, EncryptionFactoryIF)
    
    /**
     * Returns an input stream for this socket that decrypts the inbound
     * stream of bytes.
     *
     * @return     an input stream for reading decrypted bytes from this
     *             socket. 
     * @exception  IOException  if an I/O error occurs when creating the
     *               input stream.
     */
    public InputStream getInputStream() throws IOException {
        return crypt.decryptInputStream(super.getInputStream());
    } // getInputStream()

    /**
     * Returns an output stream for this socket that encrypts the
     * outbound stream of bytes.
     *
     * @return     an output stream for reading decrypted bytes from
     *             this socket. 
     * @exception  IOException  if an I/O error occurs when creating the
     *               output stream.
     */
    public OutputStream getOutputStream() throws IOException {
        return crypt.encryptOutputStream(super.getOutputStream());
    } // getOutputStream()
} // class EncryptedSocket
