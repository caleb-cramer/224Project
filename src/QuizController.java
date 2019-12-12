import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.LinkedList;

/**
 * @author calebcramer
 * This is the controller for the QuizPanel
 */
public class QuizController {
    private LinkedList<Integer> correctAnswers = new LinkedList<>();
    private static double percentCorrect = 0.00;
    private DecimalFormat df = new DecimalFormat("###.##");

    public QuizController(QuizPanel quizPanel, AppModel ap) {

        //timer for the quiz
        quizPanel.timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //do this while timer is counting down
                if (quizPanel.time != 0) {
                    quizPanel.time--;
                    quizPanel.timeLabel.setText(Integer.toString(quizPanel.time));
                }
                //do this when the timer is done
                else {
                    quizPanel.timer.stop();
                    quizPanel.divisionPanel.setVisible(false);
                    quizPanel.submit.setEnabled(false);
                    percentCorrect = (1 - getResult(quizPanel.answers) / (double) correctAnswers.size()) * 100;
                    quizPanel.statusLabel.setText("Timer's Up! You got " + df.format(percentCorrect) + "% correct!");
                    CurrentUser.changeLast(percentCorrect);
                    ap.updateLearner();
                }
            }
        });

        //start the quiz will start the timer and changes which buttons are enabled
        quizPanel.startQuiz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                quizPanel.timer.start();
                quizPanel.startQuiz.setEnabled(false);
                quizPanel.submit.setEnabled(true);
            }
        });

//        quizPanel.restart.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent actionEvent) {
//                TabbedPanel.newQuizPanel(ap);
//            }
//        });

        //submit button sends the input and the rest of the problem to the model
        quizPanel.submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                correctAnswers.add(quizPanel.getRightAnswer());
                String quot = quizPanel.getQuotient();
                if (!quot.equals("")) {
                    quizPanel.addToList(quot);
                }
                else{
                    quizPanel.addToList("0");
                }
                quizPanel.newQuestion();
            }

        });

    }

    //finds percentage that they got it right
    private int getResult(LinkedList<Integer> abc) {
        int wrongAns = 0;
        for (int i = 0; i < abc.size(); i++) {
            if (!this.correctAnswers.get(i).equals(abc.get(i))) {
                wrongAns++;
            }
        }
        return wrongAns;
    }

}
