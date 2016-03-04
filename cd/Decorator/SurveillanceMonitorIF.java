/**
 * Objects that control a surveillance monitor implement this interface.
 */
interface SurveillanceMonitorIF {
    //...
    /**
     * Make the monitor controlled by this object show the image from
     * the named camera.
     * @param camera The name of a camera.
     */
    void viewNow(String camera) ;
} // interface SurveillanceMonitorIF
