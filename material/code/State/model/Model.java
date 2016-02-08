package model;

/**
 *  This class holds the condition of the road.
 *  When the user clicks a button, to accelerate or turn left, etc.,
 *  the amount of acceleration, turn, etc., depends on the road
 *  conditions.
 *  <P>
 *  This class implements the State pattern.
 */

public class Model implements Condition {
    /** Regular condition state. */
    public final Condition regular = new Regular ();
    /** Gravel condition state. */
    public final Condition gravel = new Gravel ();
    /** Wet condition state. */
    public final Condition wet = new Wet ();
    /** Icy condition state. */
    public final Condition ice = new Ice ();
    private Condition condition = regular;
    /**
     *  Set the condition of the road.
     *  @param The condition of the road.
     */
    public void setCondition (Condition condition) {
	this.condition = condition;
    }
    /**
     *  Return the amount of acceleration.
     *  The amount originates from a button click
     *  and depends on the road conditions.
     *  @return The amount of acceleration.
     */
    public int getAccel () { return condition.getAccel (); }
    /**
     *  Return the amount of left turn.
     *  The amount originates from a button click
     *  and depends on the road conditions.
     *  @return The amount of left turn.
     */
    public int getLeft () { return condition.getLeft (); }
    /**
     *  Return the amount of right turn.
     *  The amount originates from a button click
     *  and depends on the road conditions.
     *  @return The amount of right turn.
     */
    public int getRight () { return condition.getRight (); }
    /**
     *  Return the amount of brake.
     *  The amount originates from a button click
     *  and depends on the road conditions.
     *  @return The amount of brake.
     */
    public int getBrake () { return condition.getBrake (); }
}
