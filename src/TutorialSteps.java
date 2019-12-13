/**
 * This program contains the format for a step in euclidean division
 * CPSC 3224-01, Fall 2010
 * Final Project D/VDR
 * SOURCES: None to cite.
 *
 * @author Simon Robles
 * @version v1.0 12/12/19
 */
import javax.swing.*;

public class TutorialSteps extends JPanel {
    String content;

    /*EVC*/
    public TutorialSteps(String stepContent) {
        super();
        this.content = stepContent;
        JTextField step = new JTextField(stepContent);
        add(step);
    }
}
