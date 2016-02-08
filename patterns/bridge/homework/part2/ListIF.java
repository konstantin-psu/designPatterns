interface ListIF<E> {
    public int length();
    public boolean isEmpty();
    public E head() throws IllegalStateException;
    public ListIF<E> tail() throws IllegalStateException;
}
