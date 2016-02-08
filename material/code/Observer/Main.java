import java.awt.*;
import java.applet.*;
import javax.swing.event.*;

/**
 *  This applet holds two graphical components: a TextField and a
 *  JSlider.  The value shown by each component is the same.
 *  When one value changes as a result of a user action, the
 *  other value changes accordingly.
 */

public class Main extends Applet {
    /**  Initialize the applet. */
    public void init () {
	// The observer of the components.
	Observer observer = new Observer ();
	// The two components
	Digital digital = new Digital (observer);
	Analog analog = new Analog (observer);
	// Each component implements the same interface, Settable,
	// that ensures that the value of a component can be set.
	Settable [] settable = { digital, analog };
	// Set the observable in the observer
	observer.setSettable(settable);
	// Add the components
	add(digital);
	add(analog);
	// Set the initial value
	digital.setInt (32);
	observer.update(digital,32);
    }
}
