import java.util.Vector;

class Composite extends Component {
    Vector<Component> children = new Vector<Component>();
    Composite(int x) { super(x); }
    void add(Component child) { children.add(child); }
    void remove(Component child) { children.remove(child); }
    void pp(int depth) {
	super.pp(depth);
	for (Component child : children) {
	    child.pp(depth+1);
	}
    }
}
