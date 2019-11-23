import javax.swing.*;
import java.awt.*;
import javax.swing.Timer;


public class QuizPanel extends JPanel {
    Timer timer = null;
    int time = 60;
    JLabel timeLabel;
    JLabel statusLabel = new JLabel("");
    JButton startQuiz =  new JButton("Start Quiz");
    DivisionPanel divisionPanel = new DivisionPanel();
    QuizController qc = new QuizController(this);

    public QuizPanel(){
        super(new BorderLayout());
        timeLabel  = new JLabel(Integer.toString(time));
        this.add(timeLabel, BorderLayout.NORTH);

        this.add(divisionPanel, BorderLayout.CENTER);

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.X_AXIS));
        southPanel.add(startQuiz);
        southPanel.add(statusLabel);
        this.add(southPanel, BorderLayout.SOUTH);
    }
}
