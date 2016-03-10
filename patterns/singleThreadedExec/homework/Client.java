import java.util.Random;

public class Client {
    public class Position {
        int x,y,z;
        public void set(int x, int y, int z) {
            this.x = x; this.y = y; this.z = z;
        } 
        
        public int getX() { return x; }
        public int getY() { return y; }
        public int getZ() { return z; }
        
    }

    Position position = new Position();
    Random rand = new Random();

    public class Writer extends Thread {
        public void run() {
            while (true) {
                try{
                    synchronized (position) {
                        int nextInt = rand.nextInt();
                        position.set(nextInt, nextInt, nextInt);               
                        //sleep(rand.nextInt(1000));
                    }
                    sleep(10);
                } catch (InterruptedException ie) {
                
                }
            }
        }
    }

    public class Reader extends Thread {
        public void run() {
            while (true) {
                try {
                    synchronized (position) {
                        int x,y,z;
                        x = position.getX();
                        y = position.getY();
                        z = position.getZ();
                        if ( x != y || y != z || x != z) {
                            System.out.println("Something bad happened");
                        }
                        //sleep(rand.nextInt(1000));
                    }
                    sleep(10);
                } catch (InterruptedException ie) {}
            }
        }
    }

    private void main () {
        Writer writer = new Writer();
        Reader reader = new Reader();
        writer.start ();
        reader.start ();
    }

    public static void main(String [] ignore) {
        System.out.println("Test");
        (new Client ()).main ();
        
    }
}
