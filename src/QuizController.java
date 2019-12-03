import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizController {
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
                }
            }
        });
        quizPanel.startQuiz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                quizPanel.timer.start();
            }
        });

        quizPanel.submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (quizPanel.submit.getText() != "") {
                    quizPanel.addToList(quizPanel.submit.getText());
                }
            }
        });
    }
}