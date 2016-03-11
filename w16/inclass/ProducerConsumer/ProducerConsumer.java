import java.util.Random;

class Client {
    static FakeQueue queue = new FakeQueue();
    static Producer producer = new Producer();
    static Random random = new Random();

    public static void main(String [] ignore) {
	producer.start();
    }

    static class FakeQueue {
	int counter = 0;
	final int size = 2;
	void enqueue() { 
	    Logger.log("Enqueueing");
	    counter++;
	}
	void dequeue() { 
	    Logger.log("dequeueing");
	    counter--;
	}
	boolean isFull() { return counter == 2; }
    }

    static class Producer extends Thread {
	public void run() {
	    while(true) {
		synchronized(queue) {
		    try {
			while (queue.isFull()) {
			    Logger.log("producer wait full");
			    queue.wait();
			}
			queue.enqueue();
			Logger.log("producer notify");
			queue.notify();
			queue.wait(random.nextInt(1000));
		    } catch (InterruptedException ex) {
			System.err.println("EX");
		    }
		}
	    }
	}
    }
}
