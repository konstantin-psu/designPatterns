/**
 *  This class observes the changes of an integer property
 *  in a set of observable objects.
 *  It holds a set of settable objects.
 *  When the property changes the observer sets the new value of the
 *  property to each settable object.
 *  <P>
 *  Generally, observers have methods to add and remove observables.
 *  For simplicity, here all the observable are set in one shot.
 *  This is less general, but it suffices for this problem and is
 *  less distracting.
 */

public class Observer{
    private Settable [] settable;
    /**
     *  Set the observable of this observer.
     *  @param settable The array of objectobservable to set.
     */
    public void setSettable(Settable [] settable) { this.settable = settable; }
    /**
     * Update the settables with a new value.
     * @param value The new value to set in the settable.
     */
    public void update(Settable originator, int newValue) {
	for (Settable s : settable)
	    if (s != originator) 
		s.setInt(newValue);
    }
}
