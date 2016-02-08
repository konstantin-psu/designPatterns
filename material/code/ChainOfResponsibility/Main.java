import java.awt.*;

/**
 *  This applet shows an application of the Chain of Responsibility
 *  pattern.  The applet hosts two buttons and a text field.
 *  When a button is pressed, it outputs a debugging/tracing message
 *  and it delegates to the applet the responsibility to set a similar
 *  message in the text field.
 */
public class Main extends java.applet.Applet {
    private Button onButton = new MessageButton ("On");
    private Button offButton = new MessageButton ("Off");
    private TextField text = new TextField ();
    /** Initialize the applet. */
    public void init () {
	text.setEditable (false);
	text.setBackground (Color.white);
	Panel panel = new Panel ();
	panel.setLayout (new GridLayout (1, 2, 5, 5));
	panel.add (onButton);
	panel.add (offButton);
	setLayout (new GridLayout (2, 1, 5, 5));
	add (panel);
	add (text);
    }
    /**
     *  Define the insets of this applet.
     *  @return The insets of this applet.
     */
    public Insets insets () { return new Insets (5, 5, 5, 5); }
    /**
     *  Handle action events of this applet.
     *  The action events actually handles button clicks only.
     *  @param evt Action event.
     *  @param ignore ditto.
     *  @return True if the event has been completely handled;
     *          pass to super otherwise.
     */
    
    public boolean action (Event evt, Object ignore) {
	if (evt.target.equals (onButton))
	    text.setText ("The \"On\" button has been pressed");
	else if (evt.target.equals (offButton))
	    text.setText ("The \"Off\" button has been pressed");
	// pass the responsibility along
	else return super.action (evt, ignore);
	return true;
    }
}
