import javax.swing.*;
import java.awt.*;

/**
 * @author calebcramer
 * This is our new feature for the Project
 * It is essentially tabs like for a web browser
 * You can click through each panel
 */
public class TabbedPanel extends JPanel {
    private static JTabbedPane tabbedPane = new JTabbedPane();
    public TabbedPanel() {
        super(new GridLayout(1, 1));

        //make the model in here so that each panel can access it if they need to
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

        //closes all the tabs so that the user can't move on until they enter their username
        //is undone by openTabs()
        tabbedPane.setEnabledAt(1,false);
        tabbedPane.setEnabledAt(2,false);
        tabbedPane.setEnabledAt(3,false);

        add(tabbedPane);

    }

    /**
     * This method opens all the tabs and makes them clickable after the user types in their username
     */
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
