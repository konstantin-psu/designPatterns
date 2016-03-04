/**
 * Instances of this class represent a image in a document.
 */
class Image extends DocumentElement {
    //...
    /**
     * Return the number of characters that this object contains.
     * Though images don't really contain any characters, for the sake of
     * consistenecy, we will treat an image as if it is a character.
     */
    public int getCharLength() {
        return 1;
    } // getCharLength()
} // class Image
