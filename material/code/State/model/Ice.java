package model;

/**
 *  Condition representation of icy road.
 */

public class Ice implements Condition {
    /**
     *  Return the amount of acceleration.
     *  @return The amount of acceleration.
     */
    public int getAccel () { return 3; }
    /**
     *  Return the amount of left turn.
     *  @return The amount of left turn.
     */
    public int getLeft () { return 1; }
    /**
     *  Return the amount of right turn.
     *  @return The amount of right turn.
     */
    public int getRight () { return 1; }
    /**
     *  Return the amount of brake.
     *  @return The amount of brake.
     */
    public int getBrake () { return 2; }
}
