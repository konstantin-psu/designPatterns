/**
 *  This class is driver (or test harness) for an abstract factory.
 *  The concrete factory used in the program is selected by an
 *  argument of the command line.
 */
class Client {
    /**
     *  Execution entry point.
     *  @param arg Command line arguments.
     *             Only one integer to select a concrete factory is acceptable.
     *  @exception Exception Can throw a variety of more specific exceptions.
     */
    public static void main (String [] arg) throws Exception {
        if (arg.length != 1) {
	    System.err.print ("Exactly one pizza style required: \n"
                             +"  0 (light) \n"
                             +"  1 (regular) \n"
                             +"  2 (gourmet) \n");
	    System.exit (1);
	}
	AbstractPizzaFactory apf
	    = AbstractPizzaFactory.getFactory (Integer.parseInt (arg [0]));
	AbstractCrust crust = apf.createCrust ();
	AbstractCheese cheese = apf.createCheese ();
	// sauce, toppings, etc.
	Pizza pizza = new Pizza (crust, cheese /*, sause, toppings, etc. */);
	System.out.println ("Calories: " + pizza.calories ());
    }
}
