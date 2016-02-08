/**
 * Memento objects created by a GameModel object to encapsulate a copy
 * of its state are instances of a private class declared in the
 * GameModel class. That class implements this interface.  All other
 * classes reefer to that class through this interface.
 */
interface MilestoneMementoIF {
    /**
     * This method returns a description of the milestone that this
     * object was created for.
     */
    String getDescription() ;
} // interface MilestoneMementoIF
