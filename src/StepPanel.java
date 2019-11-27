import javax.swing.*;

public class StepPanel extends JPanel {
    JTextField step;
    int stepNumber;

    public StepPanel(JTextField nextStep, int stepNom){
        this.step = nextStep;
        this.stepNumber = stepNom;
    }
}
