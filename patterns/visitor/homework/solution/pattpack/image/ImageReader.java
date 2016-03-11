package pattpack.image;

/**
 *  Interface that must be implemented by any image reader.
 *  It does not need to be public.  It is public to ease the documentation.
 */
public interface ImageReader {
    /**
     * Read the pixels of an image.
     * @param filename  The name of the file containing the pixels.
     * @return The pixels of the image.
     */
    Pixels readPixels (String filename);
}
