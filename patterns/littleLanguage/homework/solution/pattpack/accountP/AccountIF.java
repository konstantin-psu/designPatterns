package pattpack.accountP;

/**
 * Base class of all accounts.
 */
public abstract class AccountIF implements Cloneable {
    /** Shallow cloning. */
    public AccountIF clone () { 
	try { return (AccountIF) super.clone (); }
	catch (CloneNotSupportedException e) {
	    throw new RuntimeException ("Can't clone account");
          }
    }
    /** The id of this account. */
    protected int loginId;
    /** The number of connection hours used during the current month. */
    protected int connectionHoursThisMonth;
    /** The connection speed in Kbs of this login. */
    protected int connectionSpeedThisLogin;
    /**
     *  Set the login id of this account.
     *  @param loginId the login id of this account.
     */
    public void setLoginId (int loginId) { this.loginId = loginId; }
    /**
     *  Obtain the number of connection hours used during the current month.
     *  @return the number of connection hours used during the current month.
     */
    public int getConnectionHoursThisMonth () { return connectionHoursThisMonth; }
    /**
     *  Obtain the connection speed in Kbs of this login.
     *  @return the connection speed in Kbs of this login.
     */
    public int getConnectionSpeedThisLogin () { return connectionSpeedThisLogin; }
    // mailboxes, storage, comains, etc.
}






