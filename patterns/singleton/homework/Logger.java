import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;
class Logger {
    private Logger() {}
    private static Logger theInstance = new Logger();
    public static  Logger getInstance(String fpath, int verbosity) { 
        theInstance.initialize(fpath, verbosity);
        return theInstance; 
    }    
    private static BufferedWriter out = null;
    private static int defaultVerbosity = 0;

    public void initialize(String fPath, int Verbosity) {
        try {
            out = new BufferedWriter
            (new FileWriter(fPath,true));
        }
        catch (IOException e) {
            System.out.println("exception occoured"+ e);
        }
        defaultVerbosity = Verbosity;
    }

    private boolean ifExists(String fPath) {
        File f = new File(fPath);
        if(f.exists() && !f.isDirectory()) { 
            return true;
        }
        return false;
    }

    public void log(String logString) {
        try {
            out.write(new Date() + " " + logString+"\n");
            out.flush();
        }
        catch (IOException e) {
            System.out.println("exception occoured"+ e);
        }
    }

    public void log(String logString, int verbosity) {
        try {
            out.write(logString+"\n");
        }
        catch (IOException e) {
            System.out.println("exception occoured"+ e);
        }
    }

    public final int CRITICAL = 3;
    public final int WARNING  = 2;
    public final int LOG  = 1;
}
