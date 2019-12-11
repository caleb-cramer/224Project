import javax.swing.*;
import java.awt.*;

/**
 * @author calebcramer
 * This is our new feature for the Project
 * It is essentially tabs like for a web browser
 * You can click through each panelg
 */
public class TabbedPanel extends JPanel {
    static JTabbedPane tabbedPane = new JTabbedPane();
    public TabbedPanel() {
        super(new GridLayout(1, 1));

        AppModel ap = new AppModel();

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

        tabbedPane.setEnabledAt(1,false);
        tabbedPane.setEnabledAt(2,false);
        tabbedPane.setEnabledAt(3,false);

        add(tabbedPane);

    }
    public static void openTabs(){
        tabbedPane.setEnabledAt(1,true);
        tabbedPane.setEnabledAt(2,true);
        tabbedPane.setEnabledAt(3,true);
    }

    public static void changeTutorial(){
        tabbedPane.setSelectedIndex(1);
    }

    public static void changeQuiz(){
        tabbedPane.setSelectedIndex(3);
    }

}
