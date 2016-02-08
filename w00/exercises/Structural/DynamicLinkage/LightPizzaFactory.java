/** 
 *  Low-calorie implementation of the AbstractPizzaFactory interface.
 *  Implementations of the abstract pizza's component are nested
 *  classes within this class.  This is generally unusual, but in
 *  this case it helps to keep each concrete pizza factory self
 *  contained, hence easier to understand.
 */
class LightPizzaFactory extends AbstractPizzaFactory {
    /** Low-calorie implementation of the AbstractCrust interface. */
    private class Crust implements AbstractCrust {
	public int calories () { return 200; }
    }
    /** Low-calorie implementation of the AbstractCheese interface. */
    private class Cheese implements AbstractCheese {
	public int calories () { return 400; }
    }
    /**
     *  Method to create a crust.
     *  @return this factory's implementation of a crust.
     */
    AbstractCrust createCrust () { return new Crust (); }
    /**
     *  Method to create a cheese.
     *  @return this factory's implementation of a cheese.
     */
    AbstractCheese createCheese () { return new Cheese (); }
}
