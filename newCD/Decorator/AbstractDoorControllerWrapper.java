/**
 * This is the superclass of all DoorController wrappers.
 */
abstract class AbstractDoorControllerWrapper implements DoorControllerIF {
    private DoorControllerIF wrappee;

    /**
     * Constructor
     * @param wrappee The DoorController object that this object will
     *        delegate to.
     */
    AbstractDoorControllerWrapper(DoorControllerIF wrappee) {
        this.wrappee = wrappee;
    } // constructor(wrappee)

    /**
     * Ask the door to open if the given key is acceptable.
     * @param key A data string presented as a key to open the door.
     */
    public void requestOpen(String key) {
        wrappee.requestOpen(key);
    } // requestOpen(String)

    /**
     * close the door
     */
    public void close() {
        wrappee.close();
    } // close()
    //...
} // class AbstractDoorControllerWrapper
