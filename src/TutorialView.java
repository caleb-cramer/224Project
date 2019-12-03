import javax.swing.*;
import java.awt.*;

public class TutorialView extends JPanel{
    JPanel tutorialPanel;
    JButton submitButton;
    DivisionPanel tutorialProblem;
    TutorialController tutorialController = new TutorialController (this);

    public TutorialView(){
        super(new BorderLayout());

        tutorialProblem = new DivisionPanel();

        tutorialPanel = new JPanel();
        tutorialPanel.setLayout(new GridLayout());

        submitButton = new JButton("Submit");

        add(tutorialProblem, BorderLayout.NORTH);
        add(tutorialPanel, BorderLayout.CENTER);
        add(submitButton, BorderLayout.SOUTH);
    }
}
