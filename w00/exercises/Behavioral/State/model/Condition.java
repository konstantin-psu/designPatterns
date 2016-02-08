package model;

/**
 *  Interface of all states representing a condition of the road.
 */

interface Condition {
    /**
     *  Return the amount of acceleration.
     *  The amount originates from a button click
     *  and depends on the road conditions.
     *  @return The amount of acceleration.
     */
    public int getAccel ();
    /**
     *  Return the amount of left turn.
     *  The amount originates from a button click
     *  and depends on the road conditions.
     *  @return The amount of left turn.
     */
    public int getLeft ();
    /**
     *  Return the amount of right turn.
     *  The amount originates from a button click
     *  and depends on the road conditions.
     *  @return The amount of right turn.
     */
    public int getRight ();
    /**
     *  Return the amount of brake.
     *  The amount originates from a button click
     *  and depends on the road conditions.
     *  @return The amount of brake.
     */
    public int getBrake ();
}


