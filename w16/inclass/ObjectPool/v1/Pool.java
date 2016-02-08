import java.util.Stack;

class Pool {

    private static class Reusable implements ReusableIF {
	public void reset() { }
    }

    static Stack stack = new Stack();
    static int created = 0;
    static int held = 0;
    static void checkin(ReusableIF reusable) {
	held++;
	stack.push(reusable);
    }
    static ReusableIF checkout() {
	if (stack.isEmpty()) {
	    created++;
	    return new Reusable();
	} else {
	    held--;
	    ReusableIF tmp = (ReusableIF) stack.pop();
	    tmp.reset();
	    return tmp;
	}
    }
    static void dump() {
	System.out.println("created = "+created);
	System.out.println("held = "+held);
    }
}
