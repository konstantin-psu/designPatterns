/**
 * Top level classes of food processor are subclasses of this class
 */
public abstract class AbstractFoodProcessorProgram {
    private FoodProcessorEnvironmentIF environment;

    /**
     * The food processor environment passes a reference to itself to
     * this method. That allows instances of subclasses of this class
     * to call the methods of the food processor environement object
     * that implements the FoodProcessorEnvironmentIF interface.
     */
    public void setEnvironment(FoodProcessorEnvironmentIF environment) {
        this.environment = environment;
    } // setEnvironment(FoodProcessorEnvironmentIF)

    /**
     * Allow subclasses to fetch the reference to the environement.
     */
    protected FoodProcessorEnvironmentIF getEnvironment() {
        return environment;
    } // getEnvironment()

    /**
     * Return the name of this food processing program object.
     */
    public abstract String getName() ;

    /**
     * A call to this method tells a food processing program to start
     * doing whatever it is supposed to be doing.
     */
    public abstract void start() ;
    //...
} // class AbstractFoodProcessorProgram

