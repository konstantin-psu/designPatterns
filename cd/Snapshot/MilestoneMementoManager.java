import java.io.Serializable;
import java.util.Enumeration;
import java.util.Hashtable;

/**
 * This class collects memento objects and decides when the occurrence
 * of a milestone necessitates the creation of a new memento object.
 */
public class MilestoneMementoManager implements Serializable {
    private Hashtable mementos = new Hashtable();
    private GameModel model;

    /**
     * Constructor
     * @param model The GameModel objct that this objedt will work with
     */
    public MilestoneMementoManager(GameModel model) {
        this.model = model;
    } // constructor(GameModel)

    /**
     * A GameModel object calls this method to notify this object that
     * the player's character has achieved a milestone.  If no memento
     * with the given description has already been created then this
     * object requests the GameModel object to create one.
     */
    void snapshotMilestone(String description) {
        if (mementos.get(description) == null) {
            mementos.put(description, model.createMemento(description));
        } // if
    } // snapshotMilestone(String)

    /**
     * Return an array of memento object so that the user interface can
     * present them.
     */
    public MilestoneMementoIF[] getMilestoneMementos() {
        MilestoneMementoIF[] array;
        array = new MilestoneMementoIF[mementos.size()];
        Enumeration enum = mementos.elements();
        for (int i=0; i < array.length; i++) {
            array[i] = (MilestoneMementoIF)enum.nextElement();
        } // for
        return array;
    } // getMilestoneMementos()

    /**
     * Restore the game's state from the given memento object.
     */
    public void restoreFromMemento(MilestoneMementoIF memento) {
        model.setMemento(memento);
    } // restoreFromMemento(MilestoneMementoIF)
} // class MilestoneMementoManager
