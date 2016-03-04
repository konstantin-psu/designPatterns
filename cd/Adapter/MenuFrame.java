import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MenuFrame extends Frame {
    /**
     * constructor
     */
    MenuFrame() {
        super("Sample Frame");
        createMenus();
        addNotify();
        Dimension screenSize = getToolkit().getScreenSize();
        setSize(screenSize);
    } // constructor()

    // build this frame's menus
    private void createMenus() {
        Menu fileMenu = new Menu("File");
        fileMenu.add(new MenuItem("-"));
        MenuItem exit = new MenuItem("Exit");
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                close();
            } // actionPerformed(ActionEvent)
          } );
        fileMenu.add(exit);

        MenuBar mb = new MenuBar();
        mb.add(fileMenu);
        setMenuBar(mb);
    } // createMenus()

    /**
     * close this frame and exit the application.
     */
    public void close () {
        System.exit(0);
    } // close()
} // class MenuFrame
