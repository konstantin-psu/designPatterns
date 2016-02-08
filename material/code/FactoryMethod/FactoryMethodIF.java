import pattpack.account.*;

/**
 *  Abstract class to create a user based on the Factory Method pattern.
 *  Account and security manager are implemented by concrete classes.
 *  @see <A HREF="../../doc/pattpack/account/index.html">package account</A>.
 */
public abstract class FactoryMethodIF {
    /**
     *  Create an account.
     *  @param loginId the id of the created account.
     *  @return the created account.
     */
    public abstract AccountIF createAccount (int loginId);
    /**
     *  Create a security manager.
     *  @return the created security manager.
     */
    public abstract SecurityManagerIF createSecurityManager ();
    /**
     *  Create a user.
     *  @param loginId the id of the created user.
     *  @return the created user.
     */
    public User createUser (int loginId) {
	return new User (createAccount (loginId),
			 createSecurityManager ());
    }
}
