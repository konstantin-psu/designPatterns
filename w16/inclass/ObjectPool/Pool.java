import java.util.Stack;

class Pool {

    private static class Reusable extends ReusableIF {
	public void reset() { link = null; }
    }

    static ReusableIF head = null;
    static int created = 0;
    static int held = 0;
    static void checkin(ReusableIF reusable) {
	held++;
	reusable.link = head;
	head = reusable;
    }
    static ReusableIF checkout() {
	if (head == null) {
	    created++;
	    return new Reusable();
	} else {
	    held--;
	    
	    ReusableIF tmp = head;
	    head = head.link;
	    tmp.reset();
	    return tmp;
	}
    }
    static void dump() {
	System.out.println("created = "+created);
	System.out.println("held = "+held);
    }
}
