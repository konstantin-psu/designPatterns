/**
 * Created by konstantin on 1/26/16.
 */
public class Branch<E extends Comparable<E>> implements BinaryTree<E> {

    BinaryTree<E> leftBranch;
    BinaryTree<E> rightBranch;
    E value;
    public BinaryTree<E> left() {return this.leftBranch;}
    public BinaryTree<E> right() {return this.rightBranch;}
    Branch(E x, BinaryTree<E> left, BinaryTree<E> right) {
        this.value = x;
        this.leftBranch = left;
        this.rightBranch = right;
    }
    public BinaryTree<E> insert(E x) {
        int z = value.compareTo(x);
        if (z < 0) {
            rightBranch = rightBranch.insert(x);
        } else {
            leftBranch = leftBranch.insert(x);
        }
        return this;
    }

    public BinaryTree<E> root() {
        return null;
    }

    public void print() {
        leftBranch.print();
        System.out.print(value + " ");
        rightBranch.print();
    }

}
