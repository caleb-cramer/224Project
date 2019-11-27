import javax.swing.*;
import java.awt.*;

public class AppView extends JFrame {

    public AppView(){
        super("DIVDR");
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(800,400));
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new TabbedPanel(), BorderLayout.CENTER);
        pack();
    }
}
