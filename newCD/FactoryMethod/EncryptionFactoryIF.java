import java.security.Key;
import java.security.NoSuchAlgorithmException;

/**
 * This interface must be implemented by all factory classes used to
 * create instances of subclasses of Encryption.
 */
public interface EncryptionFactoryIF {
    /**
     * This method returns an instance of the appropriate subclass of
     * Encryption as determined from information provided by the given
     * Key object.
     * @param key The key that will be used to perform the encryption.
     */
    public Encryption createEncryption(Key key) throws NoSuchAlgorithmException;
} // interface EncryptionFactoryIF
