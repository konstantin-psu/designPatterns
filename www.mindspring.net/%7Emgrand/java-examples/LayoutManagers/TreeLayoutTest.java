import java.applet.*;
import java.awt.*;

/**
 * Simple demo applet for TreeLayout.
 */
public class TreeLayoutTest extends Applet {
    private TreeLayout tl;

    /**
     * set up UI
     */
    public void init() {
        tl = new TreeLayout();
        setLayout(tl);
        Button root = new Button("This is the root");
        add("Root", root); tl.setRoot(root);
        Component x = new Label("A random label");
        add("label", x);tl.setParent(x, root);
        Component y;
        y = new TextField("Add any component");
        add("comp", y); tl.setParent(y, root);
        x = new List();
        ((List)x).addItem("List entry");
        ((List)x).addItem("Similarly useless list entry");
        add("list", x); tl.setParent(x, root);
        x=new Button("Extremely long and unnecessary button title");
        add("button", x); tl.setParent(x, y);
        x = new TreeLayoutTestCanvas(getImage(getDocumentBase(),
                                              "vc48.gif"));
        add("image", x); tl.setParent(x, y);
        resize(preferredSize());
    } // init()

    /**
     * override paint to draw lines of tree.
     */
    public void paint(Graphics g) {
        super.paint(g);
        tl.paintLines(g, getBackground());
    } // paint(Graphics)
} // TreeLayoutTest


/**
 * quick and dirty component to dsplay an image.
 */
class TreeLayoutTestCanvas extends Canvas {
    private Image img;

    /**
     * Constructor.
     * @param img The image for this componet to display
     */
    TreeLayoutTestCanvas(Image img) {
        this.img = img;
    } // Constructor(Image)

    /**
     * Return hard-wired preferred size.
     */
    public Dimension preferredSize() {
        return new Dimension(64, 64);
    }  // preferredSize()

    /**
     * Override update to avoid flicker.
     */
    public void update(Graphics g) { paint(g); }

    /**
     * paint tree lines
     */
    public void paint(Graphics g) {
        g.drawImage(img, 0, size().height/2 - 16, 32, 32, this);
    } // paint(Graphics)
} // class TreeLayoutTestCanvas
