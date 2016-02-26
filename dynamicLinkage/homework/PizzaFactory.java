import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;

import static java.lang.System.exit;

/**
 * Created by konstantin on 2/26/16.
 */
public class PizzaFactory {
    private static URL[] classPath;

    Crust crust;
    ArrayList<Sauce> sauce = new ArrayList<Sauce>();
    PizzaSize size;
    ArrayList<Cheese> cheese = new ArrayList<Cheese>();
    ArrayList<Meat> meat  = new ArrayList<Meat>();
    ArrayList<Topping> toppings = new ArrayList<Topping>();

    String[]params;

    public PizzaFactory(String[] params) {
        this.params = params;
        System.out.println(params[0]);
    }

    public Pizza build() {
        buildPizza();
        return new Pizza(crust, size,sauce,cheese,meat,toppings);
    }

    private void buildPizza() {
        for(String c: params) {
            try {
                toppings.add((Topping) classLoader(c));
            } catch (java.lang.ClassCastException e) {
                try {
                    System.out.println(c + " Is not a topping");
                    meat.add((Meat) classLoader(c));
                } catch (java.lang.ClassCastException eMeat) {
                    try {
                        System.out.println(c + " Is not a meat");
                        cheese.add((Cheese) classLoader(c));
                    } catch (java.lang.ClassCastException eCheese) {
                        try {
                            System.out.println(c + " Is not a cheese");
                            size = (PizzaSize) classLoader(c);
                        } catch (java.lang.ClassCastException ePsize) {
                            try {
                                System.out.println(c + " Is not a PizzaSize");
                                sauce.add((Sauce) classLoader(c));
                            } catch (java.lang.ClassCastException eSauce) {
                                try {
                                    System.out.println(c + " Is not a Sauce");
                                    crust = (Crust) classLoader(c);
                                } catch (Exception eE) {
                                    System.out.println("Unkown component " + c);
                                }
                            }
                        }
                    }
                }
            }

        }
    }

    public Object classLoader(String classname) {
        Class programClass;
        URLClassLoader classLoader;
        try {
            classPath = new URL[]{new URL("file:///bin")};
        } catch (Exception e) {
            System.out.println(e);
        }

        classLoader = new URLClassLoader(classPath);
        try {
            programClass = classLoader.loadClass(classname);
        } catch (Exception e) {
            programClass = null;
            System.out.println(e);
            exit(1);
        }
        try {
            return programClass.newInstance();
        } catch (Exception e) {
            System.out.println(e);
            exit(1);
        }
        exit(1);
        return null;
    }
}
