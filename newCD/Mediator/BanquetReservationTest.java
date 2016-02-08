import com.sun.java.swing.JFrame;

/**
 * Class to exercise BanquetReservationDialog.
 */
public class BanquetReservationTest extends JFrame {
    public static void main(String[] argv) {
        BanquetReservationTest b = new BanquetReservationTest();
        b.show();
        new BanquetReservationDialog(b).show();
    } // main(String[])
} // class BanquetReservationTest

