package pattpack.pooledlist;

/**
 * Abstract base class of all lists.
 */
public abstract class List<E> {
    /**
     * Compute the length of this list.
     * @return The length of this list.
     */ 
    public abstract int length ();
    /**
     * Tell whether this list contains any object.
     * @return Whether this list contains any object.
     */ 
    public abstract boolean isEmpty ();
    /**
     * Compute the head of this list.
     * @return The head of this list.
     * @exception IllegalStateException When the list is empty.
     */ 
    public abstract E head () throws IllegalStateException;
    /**
     * Compute the tail of this list.
     * @return The tail of this list.
     * @exception IllegalStateException When the list is empty.
     */ 
    public abstract List<E> tail () throws IllegalStateException;
}
