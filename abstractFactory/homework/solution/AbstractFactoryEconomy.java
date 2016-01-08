/**
 *  Economy implementation of a factory of accounts.
 *  @see <A HREF="../../doc/pattpack/account/index.html">package account</A>.
 */
public class AbstractFactoryEconomy implements AbstractFactoryIF {
    /**
     *  Create an economy account.
     *  @param loginId the numeric id of the created account.
     *  @return a new economy account.
     */
    public AccountIF createAccount (int loginId) {
	return new AccountEconomy (loginId);
    }
    /**
     *  Create an economy security manager.
     *  @return a new economy security manager.
     */
    public SecurityManagerIF createSecurityManager () {
	return new SecurityManagerEconomy ();
    }
}
