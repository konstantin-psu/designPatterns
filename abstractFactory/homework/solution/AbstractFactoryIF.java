/**
 *  Interface to create accounts and security managers.
 *  The structure follows the Abstract Factory pattern.
 *  Account and security manager are created by implementations.
 *  @see <A HREF="../../doc/pattpack/account/index.html">package account</A>.
 */
public interface AbstractFactoryIF {
    /**
     *  Create an account.
     *  @param loginId the id of the created account.
     *  @return the created account.
     */
    AccountIF createAccount (int loginId);
    /**
     *  Create a security manager.
     *  @return the created security manager.
     */
    SecurityManagerIF createSecurityManager ();
}
