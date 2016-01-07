// Revision June 28, 2007

import java.io.*;
import java.util.*;

/**
 * This class is a facility to log messages on a file.
 * Its constructor is private since it implements the Singleton pattern.
 * <P>
 * Logging allows some parameterization, such as the file in which
 * messages are logged and the verbosity of the messages.
 * Since the constructor is private, the initializing parameters
 * cannot be passed to the class via the constructor.
 * <P>
 * The initialization of this class is made via a property file
 * that is read an processed at load time by a static block, see below.
 */

public class Logger {
    /** Unique instance of this class. */
    private static Logger logger = null;
    /** File where messages are logged to. */
    private PrintWriter logFile;
    /** Whether or not log messages are verbose. */
    private int verbose;
    /** Whether or not log messages go to System.err too. */
    private boolean realtime;
    /** <B>Private</B> constructor. */
    private Logger () {}

    /**
     *  Logger's configuration block.
     *  Reads file "config.txt".
     */
    static {
        Properties property = new Properties ();
        String propertyFile = "config.txt";
        try {
            // Here is were we create the only instance
            logger = new Logger ();
            property.load (new FileInputStream (propertyFile));
            logger.verbose
                = Integer.parseInt (property.getProperty ("verbose", "1"));
            logger.realtime
                = Boolean.valueOf (
	            property.getProperty ("realtime", "false")).booleanValue ();
            String logFilename
                = property.getProperty ("logfile", "logfile.txt");
	    logger.logFile
                = new PrintWriter (
                    new BufferedWriter (
		        new FileWriter (logFilename, true)));
            logger.logFile.println ();
            logger.log ("logger initialize");
            logger.log ("  configuration file \"" + propertyFile + "\"");
            logger.log ("  log file \"" + logFilename + "\"");
            logger.log ("  verbosity level " + logger.verbose);
            logger.log ("  realtime " + logger.realtime);
	} catch (NumberFormatException e) {
	    System.err.println ("Number format error in file \""
				+propertyFile+"\": "+e.getMessage());
	    System.exit(1);
	} catch (FileNotFoundException e) {
	    System.err.println ("Property file \""
				+propertyFile+"\" not found: "+e.getMessage());
	    System.exit(1);
	} catch (IOException e) {
	    System.err.println ("IO error reading file \""
				+propertyFile+"\": "+e.getMessage());			
	    System.exit(1);
	}
    }

    /**
     * Return the unique instance of this class.
     * @return The unique instance of the logger object.
     */
    public static Logger getInstance () { return logger; }

    /**
     * Log a message to the log file and optionally to standard error.
     * The amount of logging, if any at all, depends on initialization
     * parameters.
     * @param s The message to log to the log file.
     */
    public void log (String s) {
	// this should be optimized using a StringBuffer or several prints
	if (verbose > 0) {
	    String t = "";
	    if (verbose > 1) t += new Date () + " ";
	    t += s;
	    logFile.println (t);
	    logFile.flush ();
	    if (realtime) System.err.println (t);
	}
    }
}
