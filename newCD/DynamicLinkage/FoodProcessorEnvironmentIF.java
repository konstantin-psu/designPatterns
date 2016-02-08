/**
 * Food processor programs call methods of classes that implement this
 * interface.
 */
public interface FoodProcessorEnvironmentIF {
    /**
     * Make a slice of food of the given width.
     * @param width The width of the slice to make.
     */
    public void slice(int width) ;

    /**
     * Mix food at the given speed.
     * @param speed The speed to mix at.
     */
    public void mix(int speed) ;

    /**
     * Weigh food.
     * @return the wieght in ounces.
     */
    public double weigh() ;

    //...
} // interface FoodProcessorEnvironmentIF
