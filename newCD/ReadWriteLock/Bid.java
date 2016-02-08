/**
 * instances of this class encapsulate the current bid for an auction.
 */
public class Bid {
    private int bid = 0;
    private ReadWriteLock lockManager = new ReadWriteLock();
    //...
    public int getBid() throws InterruptedException{
        lockManager.readLock();
        int bid = this.bid;
        lockManager.done();
        return bid;
    } // getBid()

    public void setBid(int bid) throws InterruptedException {
        lockManager.writeLock();
        if (bid > this.bid) {
            this.bid = bid;
        } // if
        lockManager.done();
    } // setBid(int)
} // class Bid
