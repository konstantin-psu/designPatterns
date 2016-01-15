import pattpack.accountP.*;

/**
 *  This class is only a driver to show how to use
 *  a prototype pattern.  The factory is about computer
 *  accounts of various classes referred to as <EM>Economy</EM>,
 *  <EM>Standard</EM> and <EM>Professional</EM>.
 *  For the purpose of this exercise, only <EM>Economy</EM>
 *  accounts are implemented.
 */
public class Main {
    /**
     *  Standard entry.  The program reads a single integer.
     *  The integer stands for a login id. Different ranges
     *  of ids give accounts of different classes.
     */
    public static void main (String [] loginIDarray) {
	if (loginIDarray.length != 1) {
	    System.err.println ("Command requires an argument");
	    System.exit (1);
	}
	int loginId = -1;
	try { loginId = Integer.parseInt (loginIDarray [0]); }
	catch (NumberFormatException ex) {
	    System.err.println ("Argument must be an integer");
	    System.exit (1);
	}

	AccountIF account = null;
	SecurityManagerIF securityManager = null;
	if (1000 < loginId && loginId <= 5000) {
	    account = new AccountEconomy(0);
	    securityManager = new SecurityManagerEconomy();
//      Standard and professional products haven't been coded, yet
//	} else if (5000 < loginId && loginId <= 8000) {
//	    account = new AccountStandard(0);
//          securityManager = new SecurityManagerStandard();
//	} else if (8000 < loginId && loginId <= 9999)
//	    account = new AccountProfessional(0);
//          securityManager = new SecurityManagerProfessional();
	} else {
	    System.err.println ("Argument out of range");
	    System.exit (1);
	}

	PrototypeFactory  factory
	    = new PrototypeFactory (account, securityManager);
	// Note how the following code is independent of the
        // account type: economy, standard or professional. 
	// Both the account and the security manager are
	// created consistently (for each other) by the factory.
	User user
	    = new User (factory.createAccount (loginId),
			factory.createSecurityManager ());
	System.out.println (user);
    }
}
