import java.io.*;
import java.util.*;

/**
 * This class is a facility to log messages on a file.
 * Its construct is private since it implements the Singleton pattern.
 */
public class Logger {
    private static Logger logger = null;
    private PrintWriter logFile;
    private int verbose;
    private boolean realtime;
    private Logger () {}
    /**
     * Intialize and return the unique instance of this class.
     * This method should be called only once throughout an entire
     * program execution.
     * @param filename The name of the file to log messages to.
     * @param verbose Verbosity level: the higher the value the more is logged.
     * @param realtime If true logged messages are immediately printed
     *                 on standard error.
     * @return The unique instance of the logger object.
     */
    public static Logger getInstance (String filename, int verbose, boolean realtime) {
	if (logger != null)
	    throw new RuntimeException ("Logger already initialized");
	else {
	    logger = new Logger ();
	    logger.verbose = verbose;
	    logger.realtime = realtime;
	    try {
		logger.logFile
		    = new PrintWriter (
		          new BufferedWriter (
                              new FileWriter (filename, true)));
		logger.logFile.println ();
	    } catch (Exception e) {
		System.err.println ("Exception "+e.getMessage ());
		e.printStackTrace ();
	    } 
	}
	return logger;
    }

    /**
     * Return the unique instance of this class.
     * This method should be called only after the unique instance
     * of the logger has been created by an invocation of the
     * getInstance method that takes initialization parameters.
     * @return The unique instance of the logger object.
     */
    public static Logger getInstance () {
	if (logger == null)
	    throw new RuntimeException ("Logger not initialized");
	else
	    return logger;
    }

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
