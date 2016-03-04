import java.net.Socket;

/**
 * Instances of this class represent a session that a client has with a
 * server that uses the instance of this class. 
 */
public class Session implements Runnable {
    private Thread myThread;
    private Portfolio portfolio;
    private Socket mySocket;
    //...
    /**
     * Constructor
     * @param s The socket that this session should use to communicate
     *          with its client.
     */
    public Session(Socket s) {
        myThread = new Thread(this);
        mySocket = s;
        //...
    } // constructor()

    /**
     * Top level logic for a session.
     */
    public void run() {
        initialize();
        while (!myThread.interrupted()) {
            portfolio.sendTransactionsToClient(mySocket);
        } // while
        shutDown();
    } // run()

    /**
     * Request that this session terminate.
     */
    public void interrupt() {
        myThread.interrupt();
    } // interrupt()

    /**
     * Initialize ths object.
     */
    private void initialize() {
        //...
    } // initialize()

    /**
     * perform cleanup for this object.
     */
    private void shutDown() {
        //...
    } // shutDown()
    //...
} // class Session
