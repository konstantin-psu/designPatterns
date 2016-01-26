/**
 * Created by konstantin on 1/26/16.
 */
public class Client {
    public static void main(String [] ignored) {
        int [] testdata = { 25, 40, 35, 30, 10, 20, 15, 50, 45, };
        BinaryTree<Integer> tree = new Leaf<Integer>();
        for (int i: testdata) {
            System.out.println("inserting "+i);
            tree = tree.insert(i);
        }

        tree.print();
    }
}
