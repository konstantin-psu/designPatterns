package image;

import java.util.Hashtable;

/**
 * This class creates instances of classes that
 * read images in specific formats, e.g., gif, jpeg, png, ...
 * It does not need to be public.  It is public to ease the documentation.
 */

public class ImageReaderFactory {
    private static Hashtable classes = new Hashtable();

    // populate the classes hashtable
    static {
        classes.put("gif", image.GifReader.class);
        classes.put("jpg", image.JpegReader.class);
        classes.put("png", image.PngReader.class);
        //...
    }
    /**
     * Create an ImageReader object to read an image in a specified format.
     * @param format The extension of the filename containing the image.
     * @return An instance of a class that reads images in a particular
     *         format, or null if the format is not understood.
     */
    public static ImageReader createImageReader (String format) {
        Class myClass = (Class) classes.get (format);
        try {
            return (ImageReader) myClass.newInstance ();
        } catch (Exception e) {
	    System.err.println ("Unknown format "+format);
            return null;
        }
    }     
}
