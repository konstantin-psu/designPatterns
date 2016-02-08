/**
 * This class represents a user of the internet service provider.
 */
public class User {
    /** The account of this user. */
    private AccountIF account;
    /** The security manager of this user. */
    private SecurityManagerIF securityManager;
    /**
     *  Construct a user object.
     *  @param account The account of this user.
     *  @param securityManager The security manager of this user.
     */
    public User (AccountIF account, SecurityManagerIF securityManager) {
	this.account = account;
	this.securityManager = securityManager;
    }
    /**
     *  Login the user into the system.
     *  @exception LimitsException is the limits for this user are exceeded.
     */
    public void login () throws LimitsException {
	securityManager.checkLimits (account);
    }
    /**
     *  Replace this user's account.
     *  Marketing pushes for account upgrades to increase profits.
     *  However, this method is quite bad.  Why?
     *  @param account The replacement account.
     */
    public void replaceAccount (AccountIF account) {
	this.account = account;
    }
    /**
     *  String representation of a user.
     */
    public String toString () {
	return "User (" + account + ", " + securityManager + ")";
    }
}
