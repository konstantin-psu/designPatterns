import java.io.Resolvable;
import java.io.Serializable;

/**
 * Instances of this class model the state of a game.
 *<p>
 * Each game will use only one instance of this class, which it will get
 * by calling this class' getGameModel method.
 */
public class GameModel implements Serializable, Resolvable {
    private static GameModel theInstance = new GameModel();
    private MilestoneMementoManager mementoManager;
    //...
    /**
     * This constructor is private to force other classes to call this
     * class' getGameModel methods to get an instace of it.
     */
    private GameModel() {
        mementoManager = new MilestoneMementoManager(this);
        //...
    } // constructor()

    /**
     * This method returns the single instance of this class that other
     * classes will use.
     */
    public static GameModel getGameModel() { return theInstance; }

    /**
     * Because this class implements the Resolvable interface,
     * ObjectInputStream objects will call this method to get the
     * instance of GameModel that they will set the state of.
     */
    public Object readResolve() {
        return getGameModel();
    } // readResolve()
    //...
    /**
     * Create a memento object that encapsulates a snapshot of this object's
     * state.
     * @param A description of the occasion the memento is created for.
     * @return The memento object.
     */
    MilestoneMementoIF createMemento(String description) {
        // Create a memento object and set its instance variables
        MilestoneMemento memento = new MilestoneMemento(description);
        memento.mementoManager = mementoManager;
        //...
        return memento;
    } // createMemento(String)
    /**
     * Restore this object's state from the given memento object.
     */
    void setMemento(MilestoneMementoIF memento) {
        MilestoneMemento m = (MilestoneMemento)memento;
        mementoManager = m.mementoManager;
        //...
    } // setMemento(MilestoneMemento)
    //...
    /**
     * Instances of this class contain a snapshot of this object's state.
     */
    private static class MilestoneMemento implements MilestoneMementoIF {
        private String description;
        //...
        /**
         * constructor
         * @param description The reason this object is being created.
         */
        MilestoneMemento(String description) {
            this.description = description;
        } // constructor(String)

        /**
         * Return a description of why this memento was created.
         */
        public String getDescription() { return description; }

        // The following variables are set by a GameModel object
        MilestoneMementoManager mementoManager;
        //...
    } // class MilestoneMemento
} // class GameModel
