import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

/**
 * @author calebcramer
 * This is the controller for the QuizPanel
 */

//caleb comment
public class QuizController {
    LinkedList<Integer> correctAnswers = new LinkedList<>();
    public QuizController(QuizPanel quizPanel){
        quizPanel.timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (quizPanel.time != 0) {
                    quizPanel.time--;
                    quizPanel.timeLabel.setText(Integer.toString(quizPanel.time));
                }
                else {
                    quizPanel.timer.stop();
                    quizPanel.statusLabel.setText("Timer's Up!");
                    quizPanel.divisionPanel.setVisible(false);
                    quizPanel.submit.setEnabled(false);
                }
            }
        });
        quizPanel.startQuiz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                quizPanel.timer.start();
                quizPanel.startQuiz.setEnabled(false);
            }
        });

        quizPanel.submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                correctAnswers.add(quizPanel.getRightAnswer());
                System.out.println("correct: " + correctAnswers + "\n");
                String quot = quizPanel.getQuotient();
                if (!quot.equals("")) {
                    quizPanel.addToList(quot);
                    System.out.println("submitted:" + quizPanel.answers);
                }
                quizPanel.newQuestion();
            }
        });
    }
}
