package pattpack.image;

/**
 *  Implementation of an image reader for images in jpeg format.
 *  It does not need to be public.  It is public to ease the documentation.
 */
public class JpegReader implements ImageReader {
    /**
     * Read the pixels of an image.
     * @param filename  The name of the file containing the pixels.
     * @return The pixels of the image.
     */
    public Pixels readPixels (String filename) {
	System.out.println ("Reading Jpeg pixels");
	return new Pixels ();
    }
}
