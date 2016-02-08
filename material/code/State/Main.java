import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import model.*;

/**
 *  This applet is a driver for an exercise about the State pattern.
 *  It uses a graphical user interface built using the MVC pattern.
 */

public class Main extends Applet {
    /** Initialize this applet. */
    public void init () { 
	setBackground (Color.darkGray);
	Model model = new Model ();
	View view = new View ();
	Controller controller = new Controller (view, model);
	add (view);
	// initialize state by programatically performing a "click". 
	view.regular.doClick ();
    }
}
