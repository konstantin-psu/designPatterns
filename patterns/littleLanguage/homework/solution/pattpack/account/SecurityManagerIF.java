package pattpack.account;

/**
 *  Interface of all security managers of an account.
 */
public abstract class SecurityManagerIF {
    /**
     *  Check that an account usage does not violate the
     *  limits set for that account.
     *  @param account The account whose limits must be checked.
     *  @exception LimitsException thrown if and only if the limits
     *    are exceeded.
     */
    public void checkLimits (AccountIF account) throws LimitsException {
	if (account.getConnectionHoursThisMonth () > getConnectionHours ())
	    throw new LimitsException ("Connection hours exceeds limit");
	if (account.getConnectionSpeedThisLogin () > getConnectionSpeed ())
	    throw new LimitsException ("Connection speed exceeds limit");
    }
    /**
     *  Get the maximum allowed connection hours.
     */
    public abstract int getConnectionHours ();
    /**
     *  Get the maximum allowed connection speed.
     */
    public abstract int getConnectionSpeed ();
}






