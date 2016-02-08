import sun.awt.AWTAccessor;
import sun.plugin.dom.exception.InvalidStateException;

/**
 * Created by konstantin on 1/26/16.
 */
public class Leaf<E extends Comparable<E>> implements BinaryTree<E> {
    public BinaryTree<E> left() {throw new InvalidStateException("Leaf");}
    public BinaryTree<E> right() {throw new InvalidStateException("Leaf");}
    public BinaryTree<E> root() {throw new InvalidStateException("Leaf");}
    public BinaryTree<E> insert(E x) {return new Branch<E>(x,new Leaf<E>(), new Leaf<E>());}
    public void print() {

    }
}
