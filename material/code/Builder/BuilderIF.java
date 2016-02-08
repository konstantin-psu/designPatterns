import pattpack.account.*;

/**
 *  Factory class to create accounts and security managers.
 *  The structure follows the Builder pattern.
 *  Account and security manager are created by implementations.
 *  @see <A HREF="../../doc/pattpack/account/index.html">package account</A>.
 */
public abstract class BuilderIF {
    /** Type token for economy concrete builder. */
    public static final int ECONOMY = 0;
    /** Type token for standard concrete builder. */
    public static final int STANDARD = ECONOMY + 1;
    /** Type token for prionalofes concrete builder. */
    public static final int PROFESSIONAL = STANDARD + 1;
    /** 
     *  Return an object of the class appropriate for
     *  the account and security manager requested by the argument.
     *  @param type The type token of the concrete builder,
     *  e.g., "economy", "standard", etc.
     *  @return a concrete builder of the requested type.
     */
    public static BuilderIF getInstance (int type) {
	switch (type) {
	case ECONOMY: return new BuilderEconomy ();
	case STANDARD: throw new RuntimeException
	    ("Standard account builder not yet implemented.");
	case PROFESSIONAL: throw new RuntimeException 
	    ("Professional account builder not yet implemented.");
	default: throw new RuntimeException 
	    ("Illegal account builder " + type + ".");
	}
    }
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
}
