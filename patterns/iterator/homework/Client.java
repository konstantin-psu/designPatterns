/**
 * Created by konstantin on 1/26/16.
 */
public class Client {
    public static void main(String [] ignored) {
        int [] testdata = { 25, 40, 35, 30, 10, 20, 15, 50, 45, };
        Tree<Integer> tree = new Tree<Integer>();
        for (int i: testdata) {
            System.out.println("inserting "+i);
            tree.insert(i);
        }

        tree.print();
    }
}
