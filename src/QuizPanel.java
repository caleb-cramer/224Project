import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import javax.swing.Timer;


public class QuizPanel extends JPanel {
    Timer timer = null;
    int time = 60;
    JLabel timeLabel;
    JLabel statusLabel = new JLabel("");
    JButton startQuiz =  new JButton("Start Quiz");
    JButton submit = new JButton("Submit");
    DivisionPanel divisionPanel = new DivisionPanel();
    QuizController qc = new QuizController(this);
    LinkedList<String> answers = new LinkedList<>();

    public QuizPanel(){
        super(new BorderLayout());
        timeLabel  = new JLabel(Integer.toString(time));
        this.add(timeLabel, BorderLayout.NORTH);

        this.add(divisionPanel, BorderLayout.CENTER);

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.X_AXIS));
        southPanel.add(startQuiz);
        southPanel.add(submit);
        southPanel.add(statusLabel);

        this.add(southPanel, BorderLayout.SOUTH);
    }
    public void addToList(String answer){
        answers.add(answer);
    }
}
