import javax.swing.*;
import java.awt.*;

public class TutorialPanel extends JPanel{
    TutorialDivisionPanel divisionPanel;
    TutorialController tutorialController;
    JPanel stepsListPanel;
    JButton calculateButton;

    public TutorialPanel(){
        super(new BorderLayout());

        //DIVISION PANEL USER INPUT
        this.divisionPanel = new TutorialDivisionPanel();

        //SUBMIT BUTTON
        this.calculateButton = new JButton("Calculate!");

        //DIVISION STEP PANEL
        this.stepsListPanel = new JPanel();
        this.stepsListPanel.setLayout(new FlowLayout());

        JScrollPane jp = new JScrollPane(this.stepsListPanel,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);


        //CONTROLLER
        this.tutorialController = new TutorialController(this);

        add(divisionPanel, BorderLayout.NORTH);
        add(calculateButton, BorderLayout.SOUTH);
        add(stepsListPanel, BorderLayout.CENTER);
//        add(jp, BorderLayout.CENTER);

//        super(new BorderLayout());
//
//        tutorialProblem = new DivisionPanel();
//
//        tutorialPanel = new JPanel();
//        tutorialPanel.setLayout(new GridLayout());
//
//        submitButton = new JButton("Submit");
//
//        add(tutorialProblem, BorderLayout.NORTH);
//        add(tutorialPanel, BorderLayout.CENTER);
//        add(submitButton, BorderLayout.SOUTH);
    }
}
