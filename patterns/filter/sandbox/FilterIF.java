abstract class FilterIF {
    abstract Elem pull();
    FilterIF previous;
    void setPrevios(FilterIF previous) {this.previous = previous;}
}
