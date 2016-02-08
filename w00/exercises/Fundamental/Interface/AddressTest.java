import java.awt.*;
import java.awt.event.*;

public class AddressTest extends Frame {
    public static void main(String[] argv) {
        new AddressTest().show();
    } // main(String[])

    AddressTest() {
        super("AddressPanel Test");
        add(new AddressPanel(), BorderLayout.CENTER);

        pack();

        addWindowListener( new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
		System.exit (0);
            } // windowClosing(WindowEvent)
        } );
    } // Constructor()
} // class AddressTest
