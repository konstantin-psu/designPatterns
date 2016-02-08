package editor;

import java.awt.*;

/**
 *  This class stands for a a graphic editor to test the
 *  execution of the commands of Command pattern example.
 *  It is a panel showing a square that can be manipulated
 *  by the commands of Command pattern.
 */

public class Editor extends Panel {
    private static final Dimension dim = new Dimension (300, 300);
    private Square square = new Square (25);
    /**
     *  Return the square held by this editor.
     *  @return The square held by this editor.
     */
    public Square getSquare () { return square; }
    /**
     *  Render this component.
     *  @param g  The graphics context.
     */
    public void paint (Graphics g) { square.paint (g); }
    /**
     *  Define the size of this component.
     *  @return The size of this component.
     */
    public Dimension getPreferredSize () { return dim; }
}
