import java.util.ArrayList;

/**
 * Created by konstantin on 2/26/16.
 */
public class Pizza {
    Crust crust;
    ArrayList<Sauce> sauce = new ArrayList<Sauce>();
    PizzaSize size;
    ArrayList<Cheese> cheese = new ArrayList<Cheese>();
    ArrayList<Meat> meat  = new ArrayList<Meat>();
    ArrayList<Topping> toppings = new ArrayList<Topping>();

    public Pizza(Crust crust, PizzaSize size, ArrayList<Sauce> sauce, ArrayList<Cheese> cheese, ArrayList<Meat> meat, ArrayList<Topping> toppings) {
        this.crust = crust;
        this.size = size;
        this.sauce = sauce;
        this.cheese = cheese;
        this.meat = meat;
        this.toppings = toppings;
    }
}
