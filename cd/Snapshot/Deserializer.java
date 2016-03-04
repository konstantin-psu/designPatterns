import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * Instances of this class respond to action events by serializing the
 * instance of GameModel associated with this object.
 */
class Deserializer implements ActionListener {
    private UserInterface ui;

    /**
     * Constructor
     * @param ui The UserInterface object that this object will obtain
     *           file names from.
     */
    Deserializer(UserInterface ui) {
        this.ui = ui;
    } // constructor(UserInterface)

    /**
     * When a user interface event occurs that implies the
     * deserialization of this game's state to a file, the user
     * interface calls this method. 
     */
    public void actionPerformed(ActionEvent evt) {
        try {
            FileInputStream fin;
            fin = new FileInputStream(ui.getSaveFileName());
            ObjectInputStream obIn = new ObjectInputStream(fin);
            // we do not use the result of the call to readObject,
            // because the GameModel class arranges for readObject to
            // set the state of the existing GameModel object rather
            // then create a copy.
            obIn.readObject();
            obIn.close();
        } catch (Exception e) {
            ui.displayError(e.getMessage());
        } // try
    } // actionPerformed(ActionEvent)
} // class Deserializer
