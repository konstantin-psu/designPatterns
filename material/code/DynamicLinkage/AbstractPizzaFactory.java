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
    static AbstractPizzaFactory getFactory (String style) throws
        ClassNotFoundException, InstantiationException,
        IllegalAccessException, IllegalArgumentException,
        MalformedURLException {
	for (String x : prefix) 
	    if (x.equals(style)) {
		String factoryName = style + suffix;
		// Alternative #1 - load from current directory
		// AbstractPizzaFactory apf =
		//    (AbstractPizzaFactory) Class.forName
		//        (factoryName).newInstance ();
		// Alternative 2 - load from URL (including JAR file)
		// It looks like only the protocol "file:" is
		// required to load files from the execution directory
		URL [] classPath = { new URL ("file:") };
		URLClassLoader classLoader = new URLClassLoader (classPath);
		Class someClass = classLoader.loadClass (factoryName);
		AbstractPizzaFactory apf = (AbstractPizzaFactory) someClass.newInstance ();
		// end of alternatives
		return apf;
	    }
	System.err.println("Pizza style \""+style+"\" not recognized "
			   +"choose one of the following: ");
	for (String x : prefix) System.err.print("\""+x+"\" ");
	System.err.println();
	throw new IllegalArgumentException ();
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
