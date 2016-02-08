import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.KeyEvent;

/**
 * This class contains static convenience methods to post KEY_TYPED
 * KeyEvents to an arbitrary component.
 * <p>
 * <strong> This won't work with versions of java before 1.1 </strong>
 */
public class KeyEventPoster {
    // prevent this class from being instantiated
    private KeyEventPoster(){}

    /**
     * Simulate a character being typed from the keyboard and being sent
     * to the given Component.
     * @param target The component to send the keystroke event to
     * @param c the character to send to the given component
     */
    public static void simulateKeyTyped(Component target, char c) {
        EventQueue q = target.getToolkit().getSystemEventQueue();
        q.postEvent(new KeyEvent(target, KeyEvent.KEY_TYPED,
                                 System.currentTimeMillis(),
                                 0, KeyEvent.VK_UNDEFINED,
                                 c));
    } // simulateKeyTyped(Component, char)

    /**
     * Simulate characters being typed from the keyboard and being
     * sent to the given Component.
     * @param target The component to send the keystroke event to
     * @param s The charcters in this string will be sent to the given
     *          component 
     */
    public static void simulateKeyTyped(Component target, String s) {
        for (int i = 0; i < s.length(); i++) {
            simulateKeyTyped(target, s.charAt(i));
        } // for
    } // simulateKeyTyped(Component, String)
} // class KeyEventPoster
