import java.awt.*;

class DirtyState {
    // Symbolic constants for events
    public static final int DIRTY_EVENT  = 1;
    public static final int APPLY_EVENT  = 2;
    public static final int SAVE_EVENT   = 3;
    public static final int REVERT_EVENT = 4;

    // Symbolic constants for states
    private final static BothDirty  bothDirty  = new BothDirty();
    private final static FileDirty  fileDirty  = new FileDirty();
    private final static ParamDirty paramDirty = new ParamDirty();
    private final static NotDirty   notDirty   = new NotDirty();

    private Parameters parameters;
    private Button apply, save, revert;

    /**
     * This constructor should be private to prevent other classes from
     * instantiating this one.  It is not private because subclasses of 
     * this class are implemented as inner classes of this class and Java
     * 1.2 does not support access of a private constructor by inner classes.
     */
    DirtyState() {
    } // constructor()

    /**
     * Initialize the state machine and return its initial state.
     * @param p The parameters object that this object will work with
     * @param apply The apply button to be enabled/disabled
     * @param save The save button to be enabled/disabled
     * @param revert The revert button to be enabled/disabled
     */
    public static DirtyState start(Parameters p,
                                   Button apply, Button save, Button revert){
        DirtyState d = new DirtyState();
        d.parameters = p;
        d.apply = apply;
        d.save  = save;
        d.revert= revert;
        return d.notDirty;
    } // start(Button, Button, Button)

    /**
     * Respond to a given event.
     * All subclasses of this class are expected to override this method.
     * @param event An event code.
     * @return the next state.
     * @exception IllegalArgumentException if event is an unexpected value.
     */
    public DirtyState processEvent(int event) {
        // This non-overridden method should never be called.
        throw new IllegalAccessError();
    } // processEvent(int)

    /**
     * This method is called when this object is becomes the current state.
     */
    protected void enter() { }

    /**
     * class to represent state for when the fields of the dialog do not match
     * the file or the working parameter values.
     */
    private class BothDirty extends DirtyState {
        /**
         * Respond to a given event.
         * @param event An event code.
         * @return the next state.
         * @exception IllegalArgumentException if event is an unexpected value.
         */
        public DirtyState processEvent(int event) {
              switch (event) {
                case DIRTY_EVENT:
                    return this;
                case APPLY_EVENT:
                    if (parameters.applyParam()) {
                        fileDirty.enter();
                        return fileDirty;
                    } // if
                case SAVE_EVENT:
                    if (parameters.saveParam()) {
                        paramDirty.enter();
                        return paramDirty;
                    } // if
                case REVERT_EVENT:
                    if (parameters.revertParam()) {
                        paramDirty.enter();
                        return paramDirty;
                    } // if
                default:
                    String msg = "unexpected event "+event;
                    throw new IllegalArgumentException(msg);
              } // switch (event)
        } // processDirtyStateEvent(int)

        /**
         * This method is called when this object is becomes the current state.
         */
        protected void enter() {
            apply.setEnabled(true);
            revert.setEnabled(true);
            save.setEnabled(true);
        } // enter
    } // class BothDirty

    /**
     * class to represent state for when the fields of the dialog match
     * the working parameter values but not the file.
     */
    private class FileDirty extends DirtyState {
        /**
         * Respond to a given event.
         * @param event An event code.
         * @return the next state.
         * @exception IllegalArgumentException if event is an unexpected value.
         */
        public DirtyState processEvent(int event) {
              switch (event) {
                case DIRTY_EVENT:
                    bothDirty.enter();
                    return bothDirty;
                case SAVE_EVENT:
                    if (parameters.saveParam()) {
                        notDirty.enter();
                        return notDirty;
                    } // if
                case REVERT_EVENT:
                    if (parameters.revertParam()) {
                        paramDirty.enter();
                        return paramDirty;
                    } // if
                default:
                    String msg = "unexpected event "+event;
                    throw new IllegalArgumentException(msg);
              } // switch (event)
        } // processDirtyStateEvent(int)

        /**
         * This method is called when this object is becomes the current state.
         */
        protected void enter() {
            apply.setEnabled(false);
            revert.setEnabled(true);
            save.setEnabled(true);
        } // enter
    } // class FileDirty

    /**
     * class to represent state for when the fields of the dialog match
     * the file but not the working parameter values.
     */
    private class ParamDirty extends DirtyState {
        /**
         * Respond to a given event.
         * @param event An event code.
         * @return the next state.
         * @exception IllegalArgumentException if event is an unexpected value.
         */
        public DirtyState processEvent(int event) {
              switch (event) {
                case DIRTY_EVENT:
                    bothDirty.enter();
                    return bothDirty;
                case APPLY_EVENT:
                    if (parameters.applyParam()) {
                        notDirty.enter();
                        return notDirty;
                    } // if
                default:
                    String msg = "unexpected event "+event;
                    throw new IllegalArgumentException(msg);
              } // switch (event)
        } // processDirtyStateEvent(int)

        /**
         * This method is called when this object is becomes the current state.
         */
        protected void enter() {
            apply.setEnabled(true);
            revert.setEnabled(false);
            save.setEnabled(false);
        } // enter
    } // class ParamDirty

    /**
     * class to represent state for when the fields of the dialog match
     * the file and the working parameter values.
     */
    private class NotDirty extends DirtyState {
        /**
         * Respond to a given event.
         * @param event An event code.
         * @return the next state.
         * @exception IllegalArgumentException if event is an unexpected value.
         */
        public DirtyState processEvent(int event) {
              switch (event) {
                case DIRTY_EVENT:
                    bothDirty.enter();
                    return bothDirty;
                default:
                    String msg = "unexpected event "+event;
                    throw new IllegalArgumentException(msg);
              } // switch (event)
        } // processDirtyStateEvent(int)

        /**
         * This method is called when this object is becomes the current state.
         */
        protected void enter() {
            apply.setEnabled(false);
            revert.setEnabled(false);
            save.setEnabled(false);
        } // enter
    } // class ParamDirty
} // class DirtyState
