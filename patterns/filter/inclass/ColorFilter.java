class ColorFilter extends FilterIF {
    int color;
    Elem pull() {
        Elem current = previous.pull();
        if (current.color == "yellow") {
            current.color = "red";
            color++;
        }
        return current;
    }
}
