import java.net.*;

/**
 *  This is an abstract pizza factory class for creating pizza components.
 *  Defines a static method to provide concrete instances of self.
 */
abstract class AbstractPizzaFactory {
    private static final String [] prefix = {
        "Light", "Regular", "Gourmet", };
    private static final String suffix = "PizzaFactory";

    /**
     *  Method to create concrete instances of this abstract class.
     *  Instances are dynamically loaded.
     *  Instances's names are obtained by concatenating a prefix,
     *  either "Light", "Regular", or "Gourmet", with the suffix
     *  "PizzaFactory".
     *  @param style An integer representing the style of
     *               pizzas to create, e.g., 0 stands for "Light".
     @  @return a concrete pizza factory
     */
    static AbstractPizzaFactory getFactory (int style) throws
        ClassNotFoundException, InstantiationException,
        IllegalAccessException, IllegalArgumentException,
        MalformedURLException {
        if (0 <= style && style <= prefix.length-1) {
            // Alternative #1 - load from current directory
            // AbstractPizzaFactory apf =
            //    (AbstractPizzaFactory) Class.forName
            //        (prefix [style] + suffix).newInstance ();
            // Alternative 2 - load from URL (including JAR file)
	    // It looks like only the protocol "file:" is
	    // required to load files from the execution directory
            URL [] classPath = { new URL ("file:") };
            URLClassLoader classLoader = new URLClassLoader (classPath);
            String name = prefix [style] + suffix;
            Class someClass = classLoader.loadClass (name);
            AbstractPizzaFactory apf = (AbstractPizzaFactory) someClass.newInstance ();
            // end of alternatives
            return apf;
        } else throw new IllegalArgumentException ();
    }

    /**
     *  Method to create a pizza's crust.
     *  @return a concrete pizza's crust.
     */
    abstract AbstractCrust createCrust ();

    /**
     *  Method to create a pizza's cheese.
     *  @return a concrete pizza's cheese.
     */
    abstract AbstractCheese createCheese ();
}
