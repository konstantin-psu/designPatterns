/**
 * Created by konstantin on 2/26/16.
 */
public class Client {

    public static void main(String [] ignore) {
        String [] params = {"Thin","Family","Chicken","BlackOlives"};
        PizzaFactory pizzaFactory = new PizzaFactory(params);
        Pizza pizza = pizzaFactory.build();

    }
}
