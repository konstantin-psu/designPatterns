package pattpack.account;

/**
 * Class abstracting an economy account.
 */
public class AccountEconomy extends AccountIF {
    /**
     *  Construct an economy account.
     *  @param loginId  The login id of this account.
     *    The login Id is used to retrieve from a database
     *    persistent data, such as the number of connection hours
     *    already used during the current month.
     */
    public AccountEconomy (int loginId) {
	this.loginId = loginId;
	// Get hoursConnectThisMonth and all other account paramteres
	// from the database.  Argument loginId is the record's key.
    }
    public String toString () {
	return "AccountEconomy (" + loginId + ")";
    }
}
