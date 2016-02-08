import java.io.*;
import java.util.*;

/**
 * This class is test harness for a logger class.
 * It reads a configuration file,
 * <A HREF=../../Creational/Singleton/logger/config.txt>config.txt</A>,
 * to configure the logger.
 * An example of log is in file
 * <A HREF=../../Creational/Singleton/logger/logfile.txt>logfile.txt</A>.
 */

public class Main {

    /**
     * Stardard entry point.  Arguments are ignored.
     * @param args Ignored
     */
    public static void main (String [] args) { (new Main()).root (); }

    private void root () {
	configure ();
	log ("application start");
	// ... do whatever this application does ...
	log ("application stop");
    }

    private void configure () {
	Properties property = new Properties ();
	String propertyFile = "config.txt";
	try {
	    property.load (new FileInputStream (propertyFile));
	    String logFilename
		= property.getProperty ("logfile", "logfile.txt");
	    int verbose
		= Integer.parseInt (property.getProperty ("verbose", "1"));
	    boolean realtime
		= Boolean.valueOf (
                    property.getProperty ("realtime", "false")).booleanValue ();
	    Logger logger = Logger.getInstance (logFilename, verbose, realtime);
	    logger.log ("logger initialize");
	    logger.log ("  configuration file \"" + propertyFile + "\"");
	    logger.log ("  log file \"" + logFilename + "\"");
	    logger.log ("  verbosity level " + verbose);
	    logger.log ("  realtime " + realtime);
	} catch (Exception e) { System.err.println ("Configuration error "+e);
	}
    }

    private void log (String s) { Logger.getInstance ().log (s); }

    /**
     * Regular finalizer.  Logs a message.
     */
    public void finalize() { Logger.getInstance ().log ("application finalize"); }
}
