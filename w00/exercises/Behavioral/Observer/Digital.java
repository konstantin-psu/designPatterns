import java.awt.*;
import java.awt.event.*;
import java.beans.*;

/**
 *  This class provides a TextField that notifies an Observer
 *  when its value changes.  It also implements an interface
 *  to change its value. 
 *  <P>
 *  Only integer values in the range 0 to 100 are accepted
 *  by the TextField.  Unacceptable values are simply ignored.
 */
public class Digital extends TextField implements Settable {
    private int value;
    /** Construct an object of this class. */
    public Digital () {	
	setColumns (3);
	// A JSlider calls setValue automatically
	addActionListener (new ActionListener () {
	    public void actionPerformed (ActionEvent evt) {
		setText (getText ());
	    }});
    }
    /** 
     *  Set the value of this TextField.
     *  @param newValue The value to set this TextField to.
     */
    public void setText (String newValue) {
	try { 
	    int intValue = Integer.parseInt (newValue);
	    if (0 <= intValue && intValue <= 100) setInt (intValue);
	    else throw new NumberFormatException ();
	} catch (NumberFormatException e) { super.setText (""+value); }
    }
    /** 
     *  Set the value of this Settable.
     *  @param intValue The value to set this Settable to.
     */
     public void setInt (int intValue) {
	if (intValue != value) {
	    int oldValue = value;
	    value = intValue;
	    super.setText (""+intValue);
	    // Component is poorer than JComponent
	    firePropertyChange ("Digital", new Integer (oldValue)
				         , new Integer (intValue));
	}
    }

//+    With the following one can use
//+    changes.firePropertyChange ("Analog", oldValue, newValue);
//+
//+    private PropertyChangeSupport changes = new PropertyChangeSupport (this);
//+    /**
//+     *  Add a PropertyChangeListener to the listener list.
//+     *  @param x The PropertyChangeListener to be added.
//+     */
//+    public void addPropertyChangeListener (PropertyChangeListener x) {
//+	changes.addPropertyChangeListener (x);
//+    }
//+    /**
//+     *  Remove a PropertyChangeListener from the listener list.
//+     *  @param x The PropertyChangeListener to be removed.
//+     */
//+    public void removePropertyChangeListener (PropertyChangeListener x) {
//+	changes.removePropertyChangeListener (x);
//+    }

}
