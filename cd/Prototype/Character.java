import java.awt.Image;

/**
 * Abstract class for characters.
 */
public abstract class Character implements Cloneable {
    private String name;
    private Image image;
    private int strength;
    //...

    /**
     * Override clone to make it public.
     */
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            // should never happen because this class implements
            // Cloneable.
            throw new InternalError();
        } // try
    } // clone()

    public String getName() {
        return name;
    } // getName()

    public void setName(String name) {
        this.name = name;
    } // setName(String)

    public Image getImage() {
        return image;
    } // getImage(Image)

    public void setImage(Image image) {
        this.image = image;
    } // setImage(Image)

    public int getStrength() {
        return strength;
    } // getStrength()

    public void setStrength(int strength) {
        this.strength = strength;
    } // setStrength(int)

    //...
} // class Character
