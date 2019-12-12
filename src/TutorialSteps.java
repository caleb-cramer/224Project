import javax.swing.*;

public class TutorialSteps extends JLabel {
    String content;

    public TutorialSteps(String stepContent) {
        super(stepContent);
        this.content = stepContent;
    }

    @Override
    public String toString() {
        return content;
    }
}
