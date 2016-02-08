public class InventoryCollection {
    //...
    /**
     * Return an Iterator for this object.
     */
    public InventoryIteratorIF iterator() {
        return new InventoryIterator();
    } // iterator()

    private class InventoryIterator implements InventoryIteratorIF {
        public boolean hasNextInventoryItem() {
            //...
        } // hasNextInventoryItem()

        public InventoryItem getNextInventoryItem() {
            //...
        } // getNextInventoryItem()

        public boolean hasPrevInventoryItem() {
            //...
        } // hasPrevInventoryItem()

        public InventoryItem getPrevInventoryItem() {
            //...
        } // getPrevInventoryItem()
    } // class InventoryIterator
    // ...
} // class InventoryCollection
