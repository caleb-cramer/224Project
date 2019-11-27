import javax.swing.*;
import java.awt.*;

public class TutorialView extends JPanel{
    JPanel tutorialPanel;
    JButton submitButton;

    public TutorialView(){
        super(new BorderLayout());

        tutorialPanel = new JPanel();
        tutorialPanel.setLayout(new GridLayout());

        submitButton = new JButton("Submit");

        add(tutorialPanel, BorderLayout.CENTER);
        add(submitButton, BorderLayout.SOUTH);
    }
}
