class ColorFilter extends FilterIF {
    Elem pull() {
        Elem current = previous.pull();
        current.color = "Joe";
        return current;
    }
}
