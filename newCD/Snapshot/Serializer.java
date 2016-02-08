import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * Instances of this class respond to action events by serializing the
 * instance of GameModel associated with this object.
 */
class Serializer implements ActionListener {
    private UserInterface ui;
    private GameModel model;

    /**
     * Constructor
     * @param ui The UserInterface object that this object will obtain
     *           file names from.
     * @param model The GameModel object that this object will be
     *              responsible for serializing.
     */
    Serializer(UserInterface ui, GameModel model) {
        this.ui = ui;
        this.model = model;
    } // constructor(UserInterface)

    /**
     * When a user interface event occurs that implies the serialization
     * of this game's state to a file, the user interface calls this
     * method.
     */
    public void actionPerformed(ActionEvent evt) {
        try {
            FileOutputStream fout;
            fout = new FileOutputStream(ui.getSaveFileName());
            ObjectOutputStream obOut = new ObjectOutputStream(fout);
            obOut.writeObject(model);
            obOut.close();
        } catch (Exception e) {
            ui.displayError(e.getMessage());
        } // try
    } // actionPerformed(ActionEvent)
} // class Serializer
