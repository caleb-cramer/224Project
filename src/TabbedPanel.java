import javax.swing.*;
import java.awt.*;

/**
 * @author calebcramer
 * This is our new feature for the Project
 * It is essentially tabs like for a web browser
 * You can click through each panelg
 */
public class TabbedPanel extends JPanel {
    public TabbedPanel() {
        super(new GridLayout(1, 1));

        AppModel ap = new AppModel();

        JTabbedPane tabbedPane = new JTabbedPane();

        //login panel
        JComponent panel1 = new LoginPanel(ap);
        tabbedPane.addTab("Login", panel1);

        //tutorial panel
        JComponent panel2 = new TutorialView();
        tabbedPane.addTab("Tutorial", panel2);

        //practice panel
        JComponent panel3 = new PracticePanel();
        tabbedPane.addTab("Practice Problems", panel3);

        //quiz panel
        JComponent panel4 = new QuizPanel(ap);
        tabbedPane.addTab("Quiz Yourself", panel4);

        add(tabbedPane);

    }
}
