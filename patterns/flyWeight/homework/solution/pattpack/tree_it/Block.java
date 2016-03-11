package pattpack.tree_it;

/**
 *  Interface for a closure-based block of a binary tree iterator.
 */

public interface Block<E> {

    /**
     * Visit an element of the iteration.
     * @param subject The element being visited
     */
    void yield(E subject);
    
}
