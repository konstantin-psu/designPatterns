import javax.swing.*;
import javax.swing.event.*;

/**
 *  This class provides a slider that notifies an Observer
 *  when its value changes.  It also implements an interface
 *  to change its value.
 */
public class Analog extends JSlider implements Settable {
    /** Construct an object of this class. */
    public Analog () { super (0, 100); }
    /** 
     *  Set the value of this slider.
     *  @param newValue The value to set this slider to.
     */
    public void setValue (int newValue) { setInt (newValue); }
    /** 
     *  Set the value of this Settable.
     *  @param intValue The value to set this Settable to.
     */
    public void setInt (int intValue) {
	int value = getValue ();
 	if (intValue == value) return;
 	int oldValue = value;
 	value = intValue;
	super.setValue (intValue);
	firePropertyChange ("Analog", oldValue, intValue);
     }
}
