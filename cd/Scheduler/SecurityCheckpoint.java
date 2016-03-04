/**
 * Instances of this class represent a security checkpoint.
 */
public class SecurityCheckpoint implements Runnable {
    private String description;
    private int checkpointID;
    private Printer printer;

    /**
     * constructor.
     * @param description A description of this SecurityCheckpoint.
     * @param checkpointID The numerid id of this checkpoint
     * @param printer The printer that prints journal entries for this
     *                SecurityCheckpoint 
     */
    public SecurityCheckpoint(String description,
                              int checkpointID,
                              Printer printer) {
        this.description = description;
        this.checkpointID = checkpointID;
        this.printer = printer;
        new Thread(this).start();
    } // constructor(String, int)

    //...
    /**
     * Return a description of this security checkpoint.
     */
    public String getDescription() { return description; }

    /**
     * top level logic for this active object.
     */
    public void run() {
        while (true) {
            boolean passed = false;
            //...
            printer.print(new JournalEntry(passed, this));
        } // while
    } // run()

    public String toString() {
        return "SecurityCheckpoint: " + getDescription();
    } // toString()
} // class SecurityCheckpoint
