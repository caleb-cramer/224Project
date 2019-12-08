import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author calebcramer
 * This is the controller for the QuizPanel
 */
public class QuizController {
    LinkedList<Integer> correctAnswers = new LinkedList<>();

    public QuizController(QuizPanel quizPanel) {
        quizPanel.timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (quizPanel.time != 0) {
                    quizPanel.time--;
                    quizPanel.timeLabel.setText(Integer.toString(quizPanel.time));
                } else {
                    quizPanel.timer.stop();
                    quizPanel.divisionPanel.setVisible(false);
                    quizPanel.submit.setEnabled(false);
                    quizPanel.statusLabel.setText("Timer's Up! You got " + getResult(quizPanel.answers) + " questions wrong");
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
                System.out.println("correct: " + correctAnswers);
                String quot = quizPanel.getQuotient();
                if (!quot.equals("")) {
                    quizPanel.addToList(quot);
                    System.out.println("submitted:" + quizPanel.answers + "\n");
                }
                quizPanel.newQuestion();
            }

        });

    }

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
