class SourceFilter extends FilterIF {
    void setPrevious(FilterIF previous) { 
	throw new IllegalStateException("No previous filter for source");
    }
    Elem pull() {
	Elem current = new Elem();
	current.color = "blue";
	current.inflated = false;
	return current;
    }
}
