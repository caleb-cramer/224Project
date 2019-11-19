import javax.swing.*;
import java.awt.*;

// allison comment

public class TabbedPanel extends JPanel {
    public TabbedPanel() {
        super(new GridLayout(1, 1));

        JTabbedPane tabbedPane = new JTabbedPane();


        //login panel
        JComponent panel1 = new JPanel();
        tabbedPane.addTab("Login", panel1);

        //tutorial panel
        JComponent panel2 = new JPanel();
        tabbedPane.addTab("Tutorial", panel2);

        //practice panel
        JComponent panel3 = new PracticePanel();
        tabbedPane.addTab("Practice Problems", panel3);

        //quiz panel
        JComponent panel4 = new JPanel();
        tabbedPane.addTab("Quiz Yourself", panel4);

        add(tabbedPane);

        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
    }
}
