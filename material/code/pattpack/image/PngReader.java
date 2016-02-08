package pattpack.image;

/**
 *  Implementation of an image reader for images in png format.
 *  It does not need to be public.  It is public to ease the documentation.
 */
public class PngReader implements ImageReader {
    /**
     * Read the pixels of an image.
     * @param filename  The name of the file containing the pixels.
     * @return The pixels of the image.
     */
    public Pixels readPixels (String filename) {
	System.out.println ("Reading PNG pixels");
	return new Pixels ();
    }
}
