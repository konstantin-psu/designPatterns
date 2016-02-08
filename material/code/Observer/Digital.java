import java.awt.*;
import java.awt.event.*;

/**
 *  This class provides a TextField that notifies an Observer
 *  when its value changes.  It also implements an interface
 *  to change its value. 
 *  <P>
 *  Only integer values in the range 0 to 100 should be given
 *  to the TextField.  Unacceptable values are simply ignored.
 */
public class Digital extends TextField implements Settable {
    /** The observer of this settable */
    private Observer observer;
    /** Construct an object of this class. */
    public Digital (Observer observer) {	
	setColumns (3);
	setText("0");
	this.observer = observer;
	addActionListener (new ActionListener () {
		public void actionPerformed (ActionEvent evt) {
		    update();
 		}
	    });
    }
    /** This should be executed in the ActionListener, but it can't. */
    private void update() {
	int value = getInt();
	if (0 <= value && value <= 100) {
	    setText(getText());
	    observer.update(this, value);
	}
    }
    
    /** 
     *  Set the value of this Settable.
     *  @param intValue The value to set this Settable to.
     */
    public void setInt (int newValue) {
	if (! (0 <= newValue && newValue <= 100)) return;
 	if (newValue != getInt()) {
	    setText(""+newValue);
	}
    }
    /**
     *  Get the value of this Settable.
     *  @return The value of this Settable.
     */
    private int getInt () {
	try {
	    return Integer.parseInt(getText ());
	} catch(NumberFormatException ex) {
	    setText("0");
	    return 0;
	}
    }
}
