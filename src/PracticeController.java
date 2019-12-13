/**
 * This is the controller for the Practice Problem tab. This allows
 * the user to interact with the "Submit Answer" button. Once a problem
 * is submitted, it is check and the user sees if they got it correct or not.
 * The user is then able to pick which tab they'd like to visit next.
 * CPSC 224-01, Fall 2019
 * 224 Project
 * No sources to cite.
 *
 * @author Allison Hayes
 * @version v1.0 12/12/19
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PracticeController {
    // fields
    private int problemNum = 1;
    protected TabbedPanel tab;

    /**
     * Constructor for PracticeController.
     * Validates user input and adds an ActionListener for
     * JButton.
     * @param practice an instance of the PracticePanel
     */
    public PracticeController(PracticePanel practice) {

        practice.submitAnswer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String quotientS = practice.problem.quotient.getText();
                // error checking for no user input
                if (quotientS.equals("")) {
                    JOptionPane.showMessageDialog(practice,
                            "You didn't enter an answer. Try again.",
                            "Invalid",
                            JOptionPane.ERROR_MESSAGE);

                }
                else {
                    String dividendS = practice.problem.dividend.getText();
                    int dividendC = Integer.parseInt(dividendS);
                    String divisorS = practice.problem.divisor.getText();
                    int divisorC = Integer.parseInt(divisorS);
                    int quotientC = Integer.parseInt(quotientS);
                    // case where user answered correctly
                    if (dividendC == (quotientC * divisorC)) {
                        String[] options = {"Back to tutorial",
                                "More practice",
                                "Quiz myself"};
                        int choice = JOptionPane.showOptionDialog(practice,
                                "You're answer is correct!",
                                "CORRECT",
                                JOptionPane.YES_NO_CANCEL_OPTION,
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                options,
                                options[2]);
                        if (choice == JOptionPane.YES_OPTION) {
                            //back to tutorial
                            tab.changeTutorial();
                        }
                        else if (choice == JOptionPane.NO_OPTION) {
                            //more practice
                            practice.newProblem();
                        }
                        else if (choice == JOptionPane.CANCEL_OPTION) {
                            //quiz
                            tab.changeQuiz();
                        }
                        problemNum = problemNum + 1;
                        practice.problemNumber.setText("Problem " + Integer.toString(problemNum));
                    }
                    // case where user answered incorrectly
                    else if (dividendC != (quotientC * divisorC)) {
                        String[] options = {"Back to tutorial",
                                "More practice",
                                "Quiz myself"};
                        int choice = JOptionPane.showOptionDialog(practice,
                                "Your answer wasn't correct.",
                                "INCORRECT",
                                JOptionPane.YES_NO_CANCEL_OPTION,
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                options,
                                options[2]);
                        if (choice == JOptionPane.YES_OPTION) {
                            //back to tutorial
                            tab.changeTutorial();
                        }
                        else if (choice == JOptionPane.NO_OPTION) {
                            //more practice
                            practice.newProblem();
                        }
                        else if (choice == JOptionPane.CANCEL_OPTION) {
                            //quiz
                            tab.changeQuiz();
                        }
                        // increment problem number
                        problemNum = problemNum + 1;
                        practice.problemNumber.setText("Problem " + Integer.toString(problemNum));
                    }
                }

            }
        });
    }
}
