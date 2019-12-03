
import javax.swing.*;
import java.awt.*;

public class PracticePanel extends JPanel {

    protected JPanel topPanel;
    protected JPanel centerPanel;
    protected JPanel bottomPanel;
    protected JLabel problemNumber;
    protected DivisionPanel problem;
    protected JButton submitAnswer;
    protected PracticeController pc;

    public PracticePanel() {
        super(new BorderLayout());

        topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));


        problemNumber = new JLabel("Problem 1");
        problemNumber.setAlignmentX(Component.CENTER_ALIGNMENT);
        topPanel.add(problemNumber);

        centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        problem = new DivisionPanel();
        problem.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(problem);

        bottomPanel= new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));

        submitAnswer = new JButton("Submit Answer");
        submitAnswer.setAlignmentX(Component.CENTER_ALIGNMENT);
        bottomPanel.add(submitAnswer);
        this.setLayout(new BorderLayout());
        this.add(topPanel, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.SOUTH);
        pc = new PracticeController(this);



        // put math panel in center panel
    }

}

