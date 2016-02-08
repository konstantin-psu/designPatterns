import java.awt.*;

/**
 *  A button that outputs a message on standard output
 *  when it is pressed.
 */
public class MessageButton extends Button {
    /** 
     *  Contruct this button.
     *  @param label  This button's label.
     */
    public MessageButton (String label) { super (label); }
    /**
     *  Handle a press of this button.
     *  @param evt The press event.
     *  @param label Ditto.
     *  @return False.
     */
    public boolean action (Event evt, Object label) {
	System.out.println ("Pressed \""+(String)label+"\" button");
	return false;
    }
}
