/**
 * All classes that control doors must implement this interface.
 */
interface DoorControllerIF {
    /**
     * Ask the door to open if the given key is acceptable.
     * @param key A data string presented as a key to open the door.
     */
    public void requestOpen(String key);

    /**
     * close the door
     */
    public void close();
    //...
} // interface DoorControllerIF
