import java.beans.*;
import java.util.*;

/**
 *  This class observes the changes of an integer property.
 *  It holds a set of settable objects.
 *  When the property changes it sets the new value of the
 *  property to each settable object.
 */

public class Observer implements PropertyChangeListener {
    private Settable [] settable;
    /**
     *  Construct an object of this class.
     *  @param settable The array of object to set to the changed property.
     */
    public Observer (Settable [] settable) { this.settable = settable; }
    /**
     *  This method gets called when a bound property is changed. 
     *  @param evt A PropertyChangeEvent object describing
     *             the event source and the property that has changed.
     */
    // This method is called also for an object it is not registered to !?
    // "ancestor" with value
    // Main[panel0,0,0,260x50,invalid,hidden,layout=java.awt.FlowLayout]
    // This is why there is the try block.
    // Another way is to check that the changed property is of
    // interest to this observer.
    public void propertyChange (PropertyChangeEvent evt) {
	try {
//	    System.out.println (evt.getPropertyName ()
//				+" from "+evt.getOldValue ()
//				+" to "+evt.getNewValue ());
	    Object source = evt.getSource ();
	    int newValue = ((Integer) evt.getNewValue ()).intValue ();
	    for (int i = 0; i < settable.length; i++)
		if (settable [i] != source)
		    settable [i].setInt (newValue);
	} catch (NullPointerException ignore) {}
    }
}
