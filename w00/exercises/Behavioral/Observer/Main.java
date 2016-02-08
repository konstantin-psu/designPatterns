import java.awt.*;
import java.applet.*;

/**
 *  This applet holds two graphical components: a TextField and a
 *  JSlider.  The value shown by each component is the same.
 *  When one value changes as a result of a user action, the
 *  other value changes accordingly.
 *  <P>
 *  There is an observer, which is also a PropertyChangeListener,
 *  that observes or listens for changes in one component to
 *  force a similar change in the other component.
 */

public class Main extends Applet {
    /**  Initialize the applet. */
    public void init () {
	// The two components
	Digital digital = new Digital ();
	Analog analog = new Analog ();
	// Each component implements the same interface, Settable,
	// that ensures that the value of a component can be set.
	Settable [] settable = { digital, analog };
	// The observer of the components.
	Observer observer = new Observer (settable);
	add (digital);
	digital.addPropertyChangeListener (observer);
	add (analog);
	analog.addPropertyChangeListener (observer);
	digital.setInt (32);
    }
}
