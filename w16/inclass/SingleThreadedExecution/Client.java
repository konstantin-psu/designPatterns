class Client {
    SingleThreadedExecution me = new SingleThreadedExecution();
    class Reader extends Thread {
	public void run() {
	    try {
		while (true) {
		    sleep(500);
		    System.out.println("-");
		    if (! me.read()) 
			System.out.println("TROUBLES");
		}
	    } catch (InterruptedException ex) {
		System.out.println("Reader exception");
	    }
	} 
    }
    class Changer extends Thread {
	public void run() {
	    try {
		while (true) {
		    sleep(200);
		    System.out.println("+");
		    me.change();
		}
	    } catch (InterruptedException ex) {
		System.out.println("Reader exception");
	    }
	} 
    }
    public static void main(String [] ignore) {
	new Client().main();
    }
    void main() {
	new Reader().start();
	new Changer().start();
    }
}
