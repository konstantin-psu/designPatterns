import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *  This class defines the view of a GUI designed according to the MVC.
 *  A number of widget are exposed (public final) so that the
 *  controller can add listeners to them.
 */

public class View extends Panel {
    /** Set road's conditions to "regular". */
    public final JRadioButton regular = new JRadioButton ("regular");
    /** Set road's conditions to "gravel". */
    public final JRadioButton gravel  = new JRadioButton ("gravel");
    /** Set road's conditions to "wet". */
    public final JRadioButton wet     = new JRadioButton ("wet");        
    /** Set road's conditions to "ice". */
    public final JRadioButton ice     = new JRadioButton ("ice");        

    /** Accelerate (amount depends on road conditions). */
    public final JButton accel = new MyButton ("accel");
    /** Turn left (amount depends on road conditions). */
    public final JButton left  = new MyButton ("left");
    /** Turn right (amount depends on road conditions). */
    public final JButton right = new MyButton ("right");
    /** Brake (amount depends on road conditions). */
    public final JButton brake = new MyButton ("brake");

    /** 
     *  Show the amount of a control: accel, left, etc.
     *  The amount depends on the road conditions.
     *  The amount value is in an integer arbitrary scale.
     */
    public final JTextField result = new JTextField ("0");

    // Pixels for insets or spacing.
    private static final int gap = 5;
    // Want all buttons the same size
    private class MyButton extends JButton {
        private final Dimension size = new Dimension (80, 25);
        private MyButton (String label) { super (label); }
        public Dimension getPreferredSize () { return size; }
    }
    // This panel makes buttons unresizable and
    // provides a separation (gap) between them
    private class InsettedPanel extends JPanel {
        private InsettedPanel (int x) {
	    insets = new Insets (x, x, x, x);
            setLayout (new FlowLayout (FlowLayout.CENTER, 0, 0));
        }
        private InsettedPanel () { this (gap); }
        private Insets insets;
        public Insets getInsets () { return insets; }
    }
    /** Construct this view */
    public View () {
        setLayout (new BorderLayout ());
        InsettedPanel buttons = new InsettedPanel (0);
        buttons.setLayout (new GridLayout (3, 1, 0, 0));
            InsettedPanel line1 = new InsettedPanel ();
            line1.add (accel);
            buttons.add (line1);
            InsettedPanel line2 = new InsettedPanel ();
            line2.setLayout (new FlowLayout (FlowLayout.CENTER, 0, 0));
            line2.add (left);
	    line2.add (new InsettedPanel ());
            line2.add (right);
            buttons.add (line2);
            InsettedPanel line3 = new InsettedPanel ();
            line3.add (brake);
            buttons.add (line3);
        add (buttons, BorderLayout.EAST);
	InsettedPanel conditions = new InsettedPanel ();
            conditions.setLayout (new GridLayout (0, 1, gap, gap));
            ButtonGroup group = new ButtonGroup ();
            group.add (regular);
            group.add (gravel);
            group.add (wet);
            group.add (ice);
            conditions.add (regular);
            conditions.add (gravel);
            conditions.add (wet);
            conditions.add (ice);
        add (conditions, BorderLayout.WEST);
        InsettedPanel forResult = new InsettedPanel ();
            forResult.setLayout (new GridLayout (1, 1));
            result.setFont (new Font ("SansSerif", Font.BOLD, 16));
	    //            result.setColumns (2);
            result.setEditable (false);
	    result.setBackground (Color.white);
            result.setHorizontalAlignment (JTextField.CENTER);
            forResult.add (result);
	add (forResult, BorderLayout.SOUTH);
    }

}

