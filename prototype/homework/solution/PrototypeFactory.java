import pattpack.accountP.*;

/**
 *  Economy implementation of a factory of accounts.
 *  @see <A HREF="../../doc/pattpack/accountP/index.html">package account</A>.
 */
public class PrototypeFactory {
    /** The prototype account for cloning. */
    private AccountIF protoAccount;
    /** The prototype security manager for cloning. */
    private SecurityManagerIF protoSecurityManager;
    /**
     * Construct a factory and initialize the prototypes.
     *  @param protoAccount the prototype account.
     *  @param protoSecurityManager the prototype security manager.
     */
    public PrototypeFactory(AccountIF protoAccount,
			    SecurityManagerIF protoSecurityManager) {
	this.protoAccount = protoAccount;
	this.protoSecurityManager = protoSecurityManager;
    }
    /**
     *  Create an account.
     *  @param loginId the numeric id of the created account.
     *  @return a new account.
     */
    public AccountIF createAccount (int loginId) {
	AccountIF account = protoAccount.clone ();
	account.setLoginId (loginId);
	return account;
    }
    /**
     *  Create an economy security manager.
     *  @return a new economy security manager.
     */
    public SecurityManagerIF createSecurityManager () {
	return protoSecurityManager.clone ();
    }
}
