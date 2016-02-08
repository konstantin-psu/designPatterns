import javax.swing.*;
import javax.swing.event.*;
/**
 *  This class provides a slider that notifies an Observer
 *  when its value changes.  It also implements an interface
 *  to change its value.
 */
public class Analog extends JSlider implements Settable {
    /** The observer of this settable */
    private final Observer observer;
    /** Construct an object of this class. */
    public Analog (Observer observer) { 
	super (0, 100);
	this.observer = observer;
	addChangeListener ( new ChangeListener () {
		    public void stateChanged(ChangeEvent e) {
			update();
		    }
	    });
    }
    /** This should be executed in the ActionListener, but it can't. */
    private void update() { observer.update(this, getValue ()); }
    /** 
     *  Set the value of this Settable.
     *  @param intValue The value to set this Settable to.
     */
    public void setInt (int newValue) {
 	if (newValue != getValue()) {
	    setValue (newValue);
	}
    }
}
