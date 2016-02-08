/**
 *  Pizza class.
 *  It is only a vehicle to employ the pizza's components
 *  created by the various pizza factories of the system.
 */
class Pizza {
    private AbstractCrust crust;
    private AbstractCheese cheese;
    /**
     *  Pizza constructor.
     *  The arguments of the constructor depend on the style of the pizza,
     *  e.g., low-calorie, regular, gourmet, etc.
     *  @param crust The crust component of this pizza.
     *  @param cheese The cheese component of this pizza.
     */     
    Pizza (AbstractCrust crust, AbstractCheese cheese) {
	this.crust = crust;
	this.cheese = cheese;	
    }
    /**
     *  Compute the total calories of this pizza by adding the
     *  calories of each component.
     *  @return The total calories of this pizza.
     */
    int calories () { return crust.calories () + cheese.calories (); }
}
