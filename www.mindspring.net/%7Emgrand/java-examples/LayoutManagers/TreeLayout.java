
import java.util.*;
import java.awt.*;

/**
 * Layout manager that arranges a Container's components in a tree.
 * The tree expands to fill the available area, and the
 * internal components are resized to fit the area proportional
 * to their preferred size and the actual available size.
 * <p>
 * There are additional method calls that must be done to inform a
 * TreeLayout object about the tree relationship between Components.
 * The setRoot method must be called to identify which Component will
 * correspond to the root of the tree.  The setParent methods identifies
 * the parent Component of a Component.  Components that are not passed
 * to setRoot or setParent are not laid out.
 * <p>
 * If the Container calls a TreeLayout's paintLines method, it will draw
 * lines between its children.
 */
public class TreeLayout implements LayoutManager {
    private TreeNode root;
    private Hashtable nodes;

    /**
     * Constructor
     */
    public TreeLayout() {
        nodes = new Hashtable();
    } // constructor()

    /**
     * Adds the specified component with the specified name to
     * the layout.
     * @param name the component name
     * @param comp the component to be added
     */
    public void addLayoutComponent(String name, Component comp) {
        TreeNode tn = new TreeNode(comp);
        nodes.put(comp, tn);
    } // addLayoutComponent(String, Component)

    public void removeLayoutComponent(Component comp) {
        nodes.remove(comp);
    } // removeLayoutComponent(Component)

    /**
     * You <em>must</em> make this call, otherwise none of the
     * components will be layed out.
     */
    public void setRoot(Component c) {
        root = (TreeNode) nodes.get(c);
    } // setRoot(Component)

    /**
     * Sets the tree parent of a child. The components <em>must</em>
     * have been previously added. If either component has not
     * previously been added, this method throws an
     * IllegalArgumentException.<p>
     * Cycles are <em>not</em> checked.
     */
    public void setParent(Component child, Component parent) {
        TreeNode p = (TreeNode) nodes.get(parent);
        if (p == null) {
            String msg = "Paren not previously added: "+parent;
            throw new IllegalArgumentException(msg);
        } // if
        TreeNode c = (TreeNode) nodes.get(child);
        if (c == null) {
            String msg = "Child not previously added: "+child;
            throw new IllegalArgumentException(msg);
        } // if
        p.addChild(c);
    } // setParent(Component, Component)

    /** 
     * Calculates the minimum size dimensions for the specified 
     * Container based on its components.
     * @param parent the component to be laid out
     * @see #preferredLayoutSize
     */
    public Dimension minimumLayoutSize(Container target) {
        Dimension d = root.minimumSize();
        Insets insets = target.insets();
        d.width += insets.left + insets.right;
        d.height += insets.top + insets.bottom;
        return d;
    } // minimumLayoutSize(Container)

    /** 
     * Calculates the preferred size dimensions for the specified 
     * Container based on its components.
     * @param parent the component to be laid out
     * @see #minimumLayoutSize
     */
    public Dimension preferredLayoutSize(Container target) {
        Dimension d = root.preferredSize();
        Insets insets = target.insets();
        d.width += insets.left + insets.right;
        d.height += insets.top + insets.bottom;
        return d;
    } // preferredLayoutSize(Container)

    /** 
     * Lays out the Components in the specified Container.
     * @param parent the Container that needs to be laid out 
     */
    public void layoutContainer(Container target) {
        Insets insets = target.insets();
        Dimension d = target.size();
        Dimension root_pref = root.preferredSize();
        int usableWidth = d.width - insets.left - insets.right;
        double xscale = (double)usableWidth/(double)root_pref.width;
        int usableHeight = d.height - insets.top - insets.bottom;
        double yscale = (double)usableHeight/(double)root_pref.height;
        root.layout(xscale, yscale, insets.left, insets.top);
    } // layoutContainer(Container)

    /**
     * Call this from the Container's paint method if you want to
     * draw lines between Components.
     * @param g The graphics object to use for drawing the lines.
     * @param bg The color to use for drawing the lines.
     */
    public void paintLines(Graphics g, Color bg) {
        Color dk = bg.darker();
        Color br = bg.brighter();
        root.paintLines(g, dk, br);
    } // paintLines(Graphics, Color)

    /**
     * Instances of this class are used to model the tree structure of
     * components.
     */
    private static class TreeNode {
        Component comp;
        Vector children;
        Dimension prefSz, minSz;

        /**
         * Construct a TreeNode to represent the given component in the
         * tree.
         */
        TreeNode(Component comp) {
            super();
            this.comp = comp;
            children = new Vector();
        }

        /**
         * Return a dimension that contains the minimum size needed to
         * paint the component associated with this node and the
         * components associated with child nodes of this node.
         */
        Dimension minimumSize() {
            if (!comp.isVisible())
              return new Dimension(0, 0);
            if (minSz == null) {
                Dimension d = comp.minimumSize();
                minSz = new Dimension(d.width, d.height);

                if (children.size() > 0) {
                    for (Enumeration e = children.elements();
                         e.hasMoreElements();) {
                        TreeNode t = (TreeNode)(e.nextElement());
                        if (t.comp.isVisible()) {
                            d = t.minimumSize();
                            minSz.height += d.height;
                            minSz.width = Math.max(d.width, minSz.width);
                        } // if
                    } // for
                } // if
            } // if
            return minSz;
        } // minimumSize() 

        /**
         * Return a dimension that contains the preferred size for
         * painting the component associated with this node and the
         * components associated with child nodes of this node.
         */
       Dimension preferredSize() {
           if (!comp.isVisible())
             return new Dimension(0, 0);
           if (prefSz == null) {
               Dimension d = comp.preferredSize();
               prefSz = new Dimension(d.width, d.height);

               if (children.size() > 0) {
                   int wmax = 0;
                   for (Enumeration e = children.elements();
                        e.hasMoreElements();) {
                       TreeNode t = (TreeNode)(e.nextElement());
                       if (t.comp.isVisible()) {
                           d = t.preferredSize();
                           prefSz.height += d.height;
                           if (wmax < d.width)
                             wmax = d.width;
                       } // if
                   } // for
                   prefSz.width += wmax;
               } // if
           }
            return prefSz;
        } // preferredSize()

        /**
         * Make the given node a child of this node.
         */
        void addChild(TreeNode t) {
            children.addElement(t);
            prefSz = null; minSz = null;
        } // addChild(TreeNode)

        /**
         * Make the given node not a child of this node.
         */
        void removeChild(TreeNode t) {
            children.removeElement(t);
            prefSz = null; minSz = null;
        }  // removeChild(TreeNode)

        /**
         * This method shaded paints lines between the Component
         * corresponding to this node and the Components that correspond
         * the children of this node.
         * @param g The Graphics object to use for drawing
         * @param dk The darker color to use in drawing shaded lines.
         * @param br The lighter color to use in drawing shaded lines.
         */
        void paintLines(Graphics g, Color dk, Color br) {
            if (comp.isVisible()) {
                Rectangle b = comp.bounds();
                int x1off = b.x + b.width/2;
                int x2off = b.x + b.width;
                int y1off = b.y;
                for (Enumeration e = children.elements();
                     e.hasMoreElements();) {
                    TreeNode tn = (TreeNode)(e.nextElement());
                    if (tn.comp.isVisible()) {
                        Rectangle bn = tn.comp.bounds();
                        int y2off = bn.y + bn.height/2;
                        g.setColor(dk);
                        g.drawLine(x1off, y1off, x1off, y2off);
                        g.drawLine(x1off, y2off-1, x2off, y2off-1);
                        g.setColor(br);
                        g.drawLine(x1off+1, y1off, x1off+1, y2off);
                        g.drawLine(x1off, y2off, x2off, y2off);
                        tn.paintLines(g, dk, br);
                    } // if
                } // for
            } // if
        } // paintLines(Graphics, Color, Color)

	/**
         * Layout the Component associated with this node and the
         * components associated with its child nodes.
         * @param xscale make the width of everything its preferred
         *        width times this scaling factor.
         * @param yscale make the height of everything its preferred
         *        height times this scaling factor.
         * @param x The x offset into the Container to do the layout.
         * @param y The y offset into the Container to do the layout.
         */
        void layout(double xscale, double yscale, int x, int y) {
            if (comp.isVisible()) {
                Dimension pref = comp.preferredSize();
                int ht = (int) Math.round(yscale*pref.height);
                int wd = (int) Math.round(xscale*pref.width);

                ht = (pref.height<ht) ? pref.height : ht;
                wd = (pref.width<wd) ? pref.width : wd;

                comp.reshape(x, y, wd, ht);
                y += ht;
                x += wd;

                for (Enumeration e = children.elements();
                     e.hasMoreElements();) {
                    TreeNode tn = (TreeNode)(e.nextElement());
                    if (tn.comp.isVisible()) {
                        pref = tn.preferredSize();
                        tn.layout(xscale, yscale, x, y);
                        y += (int) Math.round(yscale * pref.height);
                    } // if
                } // for
            } // if
        } // layout(double, double, int, int)
    } // class TreeNode
} // class TreeLayout
