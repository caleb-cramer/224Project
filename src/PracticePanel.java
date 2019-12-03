<<<<<<< HEAD

>>>>>>> 2ad002338764241f3abd8bfeff43d58f8df7f1b0
import javax.swing.*;
import java.awt.*;

public class PracticePanel extends JPanel {

    protected JPanel topPanel;
    protected JPanel centerPanel;
<<<<<<< HEAD
    protected JPanel textPanel;
    protected JPanel problemPanel;
>>>>>>> 2ad002338764241f3abd8bfeff43d58f8df7f1b0
    protected JPanel bottomPanel;
    protected JLabel problemNumber;
    protected DivisionPanel problem;
    protected JButton submitAnswer;
<<<<<<< HEAD
    protected PracticeController pc;

>>>>>>> 2ad002338764241f3abd8bfeff43d58f8df7f1b0

    public PracticePanel() {
        super(new BorderLayout());

        topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
<<<<<<< HEAD


        problemNumber = new JLabel("Problem 1");
        problemNumber.setAlignmentX(Component.CENTER_ALIGNMENT);
        topPanel.add(problemNumber);

>>>>>>> 2ad002338764241f3abd8bfeff43d58f8df7f1b0
        centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        problem = new DivisionPanel();
        problem.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(problem);
<<<<<<< HEAD


        bottomPanel= new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));

>>>>>>> 2ad002338764241f3abd8bfeff43d58f8df7f1b0
        submitAnswer = new JButton("Submit Answer");
        submitAnswer.setAlignmentX(Component.CENTER_ALIGNMENT);
        bottomPanel.add(submitAnswer);
        this.setLayout(new BorderLayout());
        this.add(topPanel, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.SOUTH);
<<<<<<< HEAD
        pc = new PracticeController(this);

>>>>>>> 2ad002338764241f3abd8bfeff43d58f8df7f1b0


        // put math panel in center panel
    }

<<<<<<< HEAD
}

>>>>>>> 2ad002338764241f3abd8bfeff43d58f8df7f1b0
