public class Client implements Runnable {
    private Queue queue;
    //...
    public void run() {
        TroubleTicket tkt = null;
        //...
        queue.push(tkt);
    } // run()
} // class Client
