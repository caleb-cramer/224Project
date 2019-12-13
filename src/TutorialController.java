/**
 * This program contains the controller that divides two integers
 * provided by the user
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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;


public class TutorialController {

    //Default Constructor
    public TutorialController(TutorialPanel tutorialPanel) {

        tutorialPanel.divisionPanel.dividend.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9') {
                    tutorialPanel.divisionPanel.dividend.setEditable(true);
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Enter only numbers",
                            "Invalid Input",
                            JOptionPane.ERROR_MESSAGE);
                    tutorialPanel.divisionPanel.dividend.setText("");
                }
            }
        });

        tutorialPanel.divisionPanel.divisor.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9') {
                    tutorialPanel.divisionPanel.divisor.setEditable(true);
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Enter only numbers",
                            "Invalid Input",
                            JOptionPane.ERROR_MESSAGE);
                    tutorialPanel.divisionPanel.divisor.setText("");
                }
            }
        });

        tutorialPanel.calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Assigning default values
                int N = 0;
                int D = 1;
                ArrayList<TutorialSteps> ourSteps;


                N = Integer.parseInt(tutorialPanel.divisionPanel.dividend.getText());
                D = Integer.parseInt(tutorialPanel.divisionPanel.divisor.getText());


                if (D == 0) {
                    JOptionPane.showMessageDialog(null,
                            "Enter a non-zero divisor",
                            "Invalid Input",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    tutorialPanel.divisionPanel.quotient.setText(divide(N, D));
                    ourSteps = divisionSteps(N, D);
                    putStepPanels(ourSteps, tutorialPanel.stepsListPanel);
                }
            }


        });
    }

    /**
     * This function populates a JPanel with panels containing the steps of division
     *
     * @param stepsArrayList is a list of TutorialSteps that will populate the parent panel
     * @param parentPanel is the panel where the list of euclidean division steps will go
     */
    public void putStepPanels(ArrayList<TutorialSteps> stepsArrayList, JPanel parentPanel){


        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                //REMOVING ALL COMPONENTS
                parentPanel.removeAll();
                parentPanel.revalidate();
                parentPanel.repaint();

                for (TutorialSteps step: stepsArrayList) {
                    parentPanel.add(step);
                }
                parentPanel.validate();
                parentPanel.repaint();
            }
        });
    }

    /**
     * This function goes through the euclidean division and creates a list of steps
     * to obtain the answer
     * @param N This is the number to divide (dividend)
     * @param D This is the number that divides N (divisor)
     * @return an array list of all necessary steps in a division problem (uses euclidean
     *          division)
     */
    public ArrayList<TutorialSteps> divisionSteps(int N, int D) {
        int quotient = 0;
        int remainder = N;
        int stepNum = 0;
        ArrayList<TutorialSteps> stepsList = new ArrayList<>();
        TutorialSteps thisStep;

        while (remainder >= D) {
            quotient++;
            remainder -= D;
            thisStep = new TutorialSteps("[" + stepNum + "]" +
                    " Quotient incremented: " + quotient +
                    " Remainder subtracted by " + D + ": " + remainder);
            stepsList.add(thisStep);
            stepNum++;
        }

        return stepsList;
    }

    /**
     * This program divides two numbers and obtains the quotient and remainder
     * @param N the number to divide
     * @param D the divisor
     * @return the quotient and remainder
     */
    public String divide(int N, int D) {
        int quotient = 0;
        int remainder = N;
        String result = "";

        while (remainder >= D) {
            quotient++;
            remainder -= D;
        }

        if (remainder == 0) {
            result = Integer.toString(quotient);
        } else {
            result = quotient + "r: " + remainder;
        }

        return result;
    }
}
