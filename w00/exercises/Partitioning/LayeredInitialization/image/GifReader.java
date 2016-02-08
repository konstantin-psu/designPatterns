package image;

/**
 *  Implementation of an image reader for images in gif format.
 *  It does not need to be public.  It is public to ease the documentation.
 */
public class GifReader implements ImageReader {
    /**
     * Read the pixels of an image.
     * @param filename  The name of the file containing the pixels.
     * @return The pixels of the image.
     */
    public Pixels readPixels (String filename) { 
	System.out.println ("Reading GIF pixels");
	return new Pixels ();
    }
}
