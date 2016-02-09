class Cons<E> implements ListIF<E> {
    // Head of the list contains some generic data
    private E head;
    // Tail of the list
    private ListIF<E> tail;
    public Cons(E head, ListIF<E> tail) {
        this.head = head;
        this.tail = tail;
    }
    public int length() {
        return 1 + tail.length();
    }
    public boolean isEmpty() {return false;}
    public E head() throws IllegalStateException {
        return head;
    }
    public ListIF<E> tail() throws IllegalStateException {
        return tail;
    }
}
