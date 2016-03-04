import java.awt.*;

class Procedural extends Dialog {
    // Symbolic constants for events
    public static final int DIRTY_EVENT  = 1;
    public static final int APPLY_EVENT  = 2;
    public static final int SAVE_EVENT   = 3;
    public static final int REVERT_EVENT = 4;

    // Symbolic constants for states
    private static final int BOTH_DIRTY  = 101;
    private static final int FILE_DIRTY  = 102;
    private static final int PARAM_DIRTY = 103;
    private static final int NOT_DIRTY   = 104;

    Button applyButton, saveButton, revertButton;

    private int state = NOT_DIRTY;

    /**
     * Constructor
     * @param parent The parent Frame
     */
    Procedural(Frame parent) {
        super(parent, "Parameter Editor");
        //...
        gotoState(NOT_DIRTY);
    } // Constructor()

    /**
     * respond to events based on the current state.
     * @param event An event code.
     * @exception IllegalArgumentException if event is an unexpected value.
     * @exception InternalError if the current state is corrupted.
     */
    private void processDirtyStateEvent(int event) {
        switch (state) {
          case BOTH_DIRTY:
              switch (event) {
                case DIRTY_EVENT:
                    // Do nothing
                    break;
                case APPLY_EVENT:
                    if (applyParam())
                      gotoState(FILE_DIRTY);
                    break;
                case SAVE_EVENT:
                    if (saveParam())
                      gotoState(PARAM_DIRTY);
                    break;
                case REVERT_EVENT:
                    if (revertParam())
                      gotoState(PARAM_DIRTY);
                    break;
                default:
                    throw new IllegalArgumentException("unexpected event "+event);
              } // switch (event)
              break;
          case FILE_DIRTY:
              switch (event) {
                case DIRTY_EVENT:
                    gotoState(BOTH_DIRTY);
                    break;
                case SAVE_EVENT:
                    if (saveParam())
                      gotoState(NOT_DIRTY);
                    break;
                case REVERT_EVENT:
                    if (revertParam())
                      gotoState(PARAM_DIRTY);
                    break;
                default:
                    throw new IllegalArgumentException("unexpected event "+event);
              } // switch (event)
              break;
          case PARAM_DIRTY:
              switch (event) {
                case DIRTY_EVENT:
                    gotoState(BOTH_DIRTY);
                    break;
                case APPLY_EVENT:
                    if (applyParam())
                      gotoState(NOT_DIRTY);
                    break;
                default:
                    throw new IllegalArgumentException("unexpected event "+event);
              } // switch (event)
              break;
          default:
            throw new InternalError("Unknown state event " + event);
        } // switch (state)
    } // processDirtyStateEvent(int)

    // Set current state and perform entry actions for the state .
    private void gotoState(int newState) {
        switch (newState) {
          case NOT_DIRTY:
              applyButton.setEnabled(false);
              revertButton.setEnabled(false);
              saveButton.setEnabled(false);
              break;
          case FILE_DIRTY:
              applyButton.setEnabled(false);
              revertButton.setEnabled(true);
              saveButton.setEnabled(true);
              break;
          case BOTH_DIRTY:
              applyButton.setEnabled(true);
              revertButton.setEnabled(true);
              saveButton.setEnabled(true);
              break;
          case PARAM_DIRTY:
              applyButton.setEnabled(true);
              revertButton.setEnabled(false);
              saveButton.setEnabled(false);
              break;
        } // switch
        state = newState;
    } // gotoState(int)

    //...
    private boolean saveParam() {
        //...
        return true;
    } // saveParam()

    private boolean applyParam() {
        //...
        return true;
    } // applyParam()

    private boolean revertParam() {
        //...
        return true;
    } // revertParam()
} // class Procedural
