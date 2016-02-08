package model;

/**
 *  Condition representation of normal road.
 */

public class Regular implements Condition {
    /**
     *  Return the amount of acceleration.
     *  @return The amount of acceleration.
     */
    public int getAccel () { return 9; }
    /**
     *  Return the amount of left turn.
     *  @return The amount of left turn.
     */
    public int getLeft () { return 5; }
    /**
     *  Return the amount of right turn.
     *  @return The amount of right turn.
     */
    public int getRight () { return 5; }
    /**
     *  Return the amount of brake.
     *  @return The amount of brake.
     */
    public int getBrake () { return 8; }
}
