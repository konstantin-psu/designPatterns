class Cons<E> implements ListIF<E> {
    E head;
    ListIF<E> tail;
    Cons(E head, ListIF<E> tail) {
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
