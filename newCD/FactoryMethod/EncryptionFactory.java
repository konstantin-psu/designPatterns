import java.security.Key;
import java.security.NoSuchAlgorithmException;

/**
 * This class creates instances of appripriate subclasses of Encryption.
 * The appropriate subclass is determined by calling the Key object's
 * 
 */
public class EncryptionFactory implements EncryptionFactoryIF {
    /**
     * This method returns an instnace of the appropriate subclass of
     * Encryption as determined from information provided by the given
     * Key object's getAlgorithm method.
     * @param key The key that will be used to perform the encryption.
     */
    public
    Encryption createEncryption(Key key) throws NoSuchAlgorithmException{
        String algorithm = key.getAlgorithm();
        if ("DES".equals(algorithm))
          return new DESEncryption(key);
        if ("RSA".equals(algorithm))
          return new RSAEncryption(key);
        throw new NoSuchAlgorithmException(algorithm);
    } // createEncryption(Key)
} // class EncryptionFactory
