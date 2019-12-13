/**
 * This program creates the general UI for our Tutorial
 * section. Contains all views for the user to input their answers and
 * see the steps to solve a division problem as per the euclidean
 * division algorithm
 * CPSC 3224-01, Fall 2010
 * Final Project D/VDR
 * SOURCES:
 * https://stackoverflow.com/questions/13510641/add-controls-vertically-instead-of-horizontally-using-flow-layout
 * https://stackoverflow.com/questions/14030124/how-to-dynamically-add-jlabels-to-jpanel
 *
 * @author Simon Robles
 * @version v1.0 12/12/19
 */
import javax.swing.*;
import java.awt.*;

public class TutorialPanel extends JPanel{
    TutorialDivisionPanel divisionPanel;
    TutorialController tutorialController;
    JPanel stepsListPanel;
    JButton calculateButton;

    // Default Value Constructor
    public TutorialPanel(){
        super(new BorderLayout());

        //DIVISION PANEL USER INPUT
        this.divisionPanel = new TutorialDivisionPanel();

        //SUBMIT BUTTON
        this.calculateButton = new JButton("Calculate!");

        //DIVISION STEP PANEL
        this.stepsListPanel = new JPanel();
        this.stepsListPanel.setLayout(new BoxLayout(this.stepsListPanel, BoxLayout.Y_AXIS));

        JScrollPane jp = new JScrollPane(this.stepsListPanel,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);


        //CONTROLLER
        this.tutorialController = new TutorialController(this);

        add(divisionPanel, BorderLayout.NORTH);
        add(calculateButton, BorderLayout.SOUTH);
        add(jp, BorderLayout.CENTER);
    }
}
