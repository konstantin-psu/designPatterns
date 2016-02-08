/**
 * Instances of this class are wrapper objects that request a type A
 * surveillance monitor to dirplay the image of a particular program.
 */
class DoorControllerWrapperA extends AbstractDoorControllerWrapper {
    private String camera;      // name of camera that views this doorway
    private SurveillanceMonitorIF monitor; // monitor for camera.

    /**
     * Constructor
     * @param wrappee The DoorController object that this object will
     *        delegate to.
     * @param camera The name of a camera that views this door
     * @param monitor The monitor to ask to view camera's image.
     */
    DoorControllerWrapperA(DoorControllerIF wrappee,
                           String camera,
                           SurveillanceMonitorIF monitor) {
        super(wrappee);
        this.camera = camera;
        this.monitor = monitor;
    } // constructor(wrappee)

    /**
     * Ask the door to open if the given key is acceptable.
     * @param key A data string presented as a key to open the door.
     */
    public void requestOpen(String key) {
        monitor.viewNow(camera);
        super.requestOpen(key);
    } // requestOpen(String)
} // class DoorControllerWrapperA
