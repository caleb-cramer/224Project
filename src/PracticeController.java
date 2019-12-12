import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PracticeController {
    private int problemNum = 1;
    protected TabbedPanel tab;


    public PracticeController(PracticePanel practice) {

        practice.submitAnswer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String quotientS = practice.problem.quotient.getText();
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
                        problemNum = problemNum + 1;
                        practice.problemNumber.setText("Problem " + Integer.toString(problemNum));
                    }
                }

            }
        });
    }
}
