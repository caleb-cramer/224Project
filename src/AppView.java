import javax.swing.*;
import java.awt.*;

/**
 * @author calebcramer
 * @implNote extends JFrame to make a new Framer
 */
public class AppView extends JFrame {

    public AppView(){
        //name of the app
        super("DIVDR");

        //normal setup for Swing GUI
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(600,600));
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new TabbedPanel(), BorderLayout.CENTER);
        pack();
    }
}
