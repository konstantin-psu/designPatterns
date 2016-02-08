package image;

/**
 *  Abstraction of an image used in a LayeredInitialization example.
 *  Images consist of common fields, such as width, length, pixels.
 *  We assume that one of these fields, pixels, must be read from
 *  the file containing the image by a reader specialized by the
 *  type or format of the image, e.g., gif, jpeg, png, etc.
 *  
 */
public class Image {

    private int width, height;
    private Pixels pixels;
    // ...
    /**
     *  Constructor.  Uses a layer for reading the pixels.
     *  @param file The name of the file containing the image.
     *              The name extension defines the image type or format.
     */
    public Image (String file) {
	int index = file.indexOf('.');
	if (index < 0) {
	    System.err.println ("No extension found in filename");
	    System.exit (1);
	}
	String format = file.substring (index + 1);
	ImageReader imageReader = ImageReaderFactory.createImageReader (format);
	if (imageReader != null) pixels = imageReader.readPixels (file);
	else System.err.println ("Image construction failed");
    }
}
