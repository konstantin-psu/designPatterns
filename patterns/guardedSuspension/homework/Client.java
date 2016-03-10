import java.util.Random;
public class Client {

    Box box = new Box();
    Random random = new Random();

    public class Box {
        int amount;
        int capacity = 1000;
        public void add(int toAdd) {
            amount += toAdd;
        }
        public boolean isFull() {
            return amount >= capacity;
        }
    } 

    public class Filler extends Thread {
        public void run() {
            synchronized(box) {
                while(!box.isFull()) {
                    int toAdd = random.nextInt(20);
                    box.add(toAdd);
                    box.notify();
                }
                try {
                    wait(random.nextInt(1000));
                }
                catch (InterruptedException ie) {
                }
            }
        }
    }

    public class Watcher extends Thread {
        public void run() {
            synchronized(box) {
                while(!box.isFull()) {
                    try {
                        wait();
                    }
                    catch (InterruptedException ie) {
                    }
                }
            }
        }
    }

    public void main() {
        System.out.println("test2");
    }
    
    public static void main (String [] ingnore) {
        (new Client()).main();
    }
}
