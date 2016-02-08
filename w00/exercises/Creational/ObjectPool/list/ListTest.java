package list;

import junit.framework.*;

public class ListTest extends TestCase {

    public ListTest (String name) { super (name); }

    public static void main (String args[]) {
        junit.textui.TestRunner.run (ListTest.class);
    }

    private List nullList;
    private List length2List;
    private List length3List;
    private Cons resettedList;
    private List otherList;
    private Object dummy;

    protected void setUp () {
	nullList = new Nil ();
	length2List = new Cons (null, new Cons (null, new Nil ()));
	length3List = new Cons (null, length2List);
	resettedList = new Cons (null, nullList);
	dummy = new Object ();
	otherList = new Cons (null, new Nil ());
	resettedList.reset (dummy, otherList);
    }  

    public void testLengthNil () {
	assert ("Bad length of Nil:", nullList.length () == 0);
    }

    public void testLengthCons () {
	assertEquals ("Wrong length of Cons:", 2, length2List.length ());
	assertEquals ("Wrong length of Cons:", 3, length3List.length ());
    }

    public void testResetHeadTail () {
	assertSame ("Bad head reset", dummy, resettedList.head ());
	assertSame ("Bad tail reset", otherList, resettedList.tail ());
    }

    public void testNullHead () {
	try {
	    Object head = nullList.head ();
	    fail ("Expected IllegalStateException from head");
	} catch (IllegalStateException ex) {
	    // OK
	}
    }

    public void testNullTail () {
	try {
	    List tail = nullList.tail ();
	    fail ("Expected IllegalStateException from tail");
	} catch (IllegalStateException ex) {
	    // OK
	}
    }

}
