// Revision June 28, 2007

import java.io.*;
import java.util.*;

/**
 * This class is a test harness for a logger class.
 * When executed, depending on a configuration file,
 * may produce a log file.
 * <P>
 * @see <A HREF="../../code/Singleton-2/config.txt">config.txt</A>,
 * the configuration file,<BR>
 * <A HREF="../../code/Singleton-2/logfile.txt">logfile.txt</A>,
 * the log file.
 */

public class Main {

    /**
     * Stardard entry point.  Arguments are ignored.
     * Call this <EM>instance</EM>'s main methods.
     * @param args Ignored
     */
    public static void main (String [] args) { (new Main()).main (); }

    /**
     *  Instance's main method.
     */
    private void main () {
	log ("application start");
	// ... do whatever this application does ...
	log ("application stop");
    }

    /**
     *  Log the argument.
     *  @param the string to log.
     */
    private void log (String s) { Logger.getInstance ().log (s); }

    /**
     * Regular finalizer.  Generally, it is not automatically invoked.
     */
    public void finalize() { Logger.getInstance ().log ("application finalize"); }
}
