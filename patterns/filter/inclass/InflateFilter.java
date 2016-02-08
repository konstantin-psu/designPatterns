class InflateFilter extends FilterIF {
    int inflate;
    Elem pull() {
        Elem current = previous.pull();
        current.inflated = true;
        inflate++;
        return current;
    }
}
