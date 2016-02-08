/**
 * This class is used to demonstrate the use of the NoExitSecurityManager
 * class.  Its constructor simply calls the System.exit method.  The
 * purpose of that is to show that the NoExitSecurityManager throws a
 * SecurityException when any hosted code calls System.exit.
 */
public class Exit 
{
    public Exit() {
        System.exit(0);
    }
}
