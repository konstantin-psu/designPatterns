import java.util.*;

class Cache {
    private static class Plot extends PlotIF {
	Plot(String ticker, long time) {
	    // blah, blah
	    System.out.println("Plot " + ticker + "  " + time);
	}
	void render() { }
    }
    static Hashtable storage = new Hashtable();
    static PlotIF getPlot(String ticker, long time) {
	AbstractMap.SimpleImmutableEntry  key = new AbstractMap.SimpleImmutableEntry(ticker, time);
	PlotIF plot = (PlotIF) storage.get(key);
	if (plot == null) {
	    plot = new Plot(ticker, time);
	    storage.put(key, plot);
	} 
	return plot;
    }
}
