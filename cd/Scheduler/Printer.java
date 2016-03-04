/**
 * Instances of this class manage the printing of JournalEntry objects.
 */
class Printer {
    private Scheduler scheduler = new Scheduler();

    /**
     * Print a journal entry
     */
    public void print(JournalEntry j) {
        try {
            scheduler.enter(j);
            //...
        } catch (InterruptedException e) {
        } //try
        scheduler.done();
    } // print(JournalEntry)
} // class Printer
