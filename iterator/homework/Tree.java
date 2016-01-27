/**
 * Created by konstantin on 1/26/16.
 */
public class Tree<E extends Comparable<E>> {
    private BinaryTree<E> treeRoot = new Leaf<E>();
    public void insert(E x) {
        treeRoot = treeRoot.insert(x);
    }
    public void print() {
        treeRoot.print();
    }
}
