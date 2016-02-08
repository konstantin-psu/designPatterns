abstract class FilterIF {
    abstract Elem pull();
    FilterIF previous;
    void setPrevious(FilterIF previous) { this.previous = previous; }
}
