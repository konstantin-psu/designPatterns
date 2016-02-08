package editor;

import java.awt.*;

/**
 *  This class abstracts a square manipulated by a naive graphics editor
 *  designed to experiment with the Command pattern.
 */

public class Square {
    // the abscissa of the square's top left corner
    private int x = 0;
    // the ordinate of the square's top left corner
    private int y = 0;
    // the color of the square
    private Color color = Color.black;
    // the rotation of the square
    private double radiants = 0.0;
    // the side of this square
    private int side;
    /**
     *  Construct a square of the given side.
     *  @param side The side of this square.
     */
    public Square (int side) { this.side = side; }
    /**
     *  Set the color of this square.
     *  @param color The color of this square.
     */
    public void setColor (Color color) { this.color = color; }
    /**
     *  Get the color of this square.
     *  @return The color of this square.
     */
    public Color getColor () { return color; }
    /**
     *  Move this square along the coordinate axes.
     *  @param dx The amount of movement along the abscissa.
     *  @param dy The amount of movement along the ordinate.
     */
    public void translate (int dx, int dy) { x += dx; y += dy; }
    /**
     *  Rotate this square around its top left corner.
     *  @param degrees The amount of rotation.
     */
    public void rotate (double radiants) { this.radiants += radiants; }

    // Since Graphics can't paint rotated rectangles, use a polygon
    private int [] xarray = new int [4];
    private int [] yarray = new int [4];
    /**
     *  Paint this square.
     *  This method, generally, is not called by the user code.
     *  @param g The graphics context.
     */
    public void paint (Graphics g) {
	double cos = side * Math.cos (radiants);
	double sin = side * Math.sin (radiants);
	xarray [0] = x;
	yarray [0] = y;
	xarray [1] = (int) (x + cos);
	yarray [1] = (int) (y + sin);
	xarray [2] = (int) (xarray [1] - sin);
	yarray [2] = (int) (yarray [1] + cos);
	xarray [3] = (int) (x - sin);
	yarray [3] = (int) (y + cos);
	g.setColor (color);
	g.fillPolygon (xarray, yarray, 4);
	g.setColor (Color.black);
	g.drawPolygon (xarray, yarray, 4);
    }
}
