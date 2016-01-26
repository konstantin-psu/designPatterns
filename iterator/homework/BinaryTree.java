/**
 * Created by konstantin on 1/26/16.
 */
public interface BinaryTree<E extends Comparable<E>> {
    public BinaryTree<E> left();
    public BinaryTree<E> right();
    public BinaryTree<E> root();
    public BinaryTree<E> insert(E x);
    public void print();
}
