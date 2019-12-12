import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

//https://stackoverflow.com/questions/14030124/how-to-dynamically-add-jlabels-to-jpanel
public class TutorialController {

    public TutorialController(TutorialPanel tutorialPanel) {
        tutorialPanel.calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Assigning default values
                int N = 0;
                int D = 1;
                ArrayList<TutorialSteps> ourSteps;

                N = Integer.parseInt(tutorialPanel.divisionPanel.dividend.getText());
                D = Integer.parseInt(tutorialPanel.divisionPanel.divisor.getText());

                tutorialPanel.divisionPanel.quotient.setText(Integer.toString(divide(N, D)));

                ourSteps = divisionSteps(N, D);
                putStepPanels(ourSteps, tutorialPanel.stepsListPanel);
                System.out.println(ourSteps);


            }


        });
    }

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
        }

        return stepsList;
    }

    public int divide(int N, int D) {
        int quotient = 0;
        int remainder = N;

        while (remainder >= D) {
            quotient++;
            remainder -= D;
        }

        return quotient;
    }
}
