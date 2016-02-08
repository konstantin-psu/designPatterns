package pattpack.pooledlist;

/**
 * Implementation of a empty list.
 */
public class Nil<E> extends List<E> {
    /**
     * Compute the length of this list.
     * @return The int 0 (zero).
     */ 
    public int length () { return 0; }
    /**
     * Tell whether this list contains any object.
     * @return The boolean value false.
     */ 
    public boolean isEmpty () { return true; }
    /**
     * This method always throws IllegalStateException.
     */ 
    public E head () throws IllegalStateException {
	throw new IllegalStateException (
	    "Attempt to compute the head of an empty list");
    }
    /**
     * This method always throws IllegalStateException.
     */ 
    public List<E> tail () throws IllegalStateException {
	throw new IllegalStateException (
	    "Attempt to compute the tail of an empty list");
    }
    
}
