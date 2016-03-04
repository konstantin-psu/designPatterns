public class Dispatcher implements Runnable {
    private Queue queue;
    //...
    public void run() {
        TroubleTicket tkt = queue.pull();
        //...
    } // run()
} // class Dispatcher
