import javax.swing.*;
import java.awt.*;

public class PracticeView extends JFrame {

    protected JPanel panel;
    protected JPanel topPanel;
    protected JPanel centerPanel;
    protected JPanel bottomPanel;
    protected JLabel problemNumber;
    protected JLabel problem;
    protected JTextField answer;
    protected JButton submitAnswer;

    public PracticeView() {
        super("Practice Problems");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 400));
        setupUI();
    }

    private void setupUI() {
        panel = (JPanel) getContentPane();
        topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        problemNumber = new JLabel("Problem 1");
        problemNumber.setAlignmentX(Component.CENTER_ALIGNMENT);
        topPanel.add(problemNumber);
        centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        problem = new JLabel("division problem");
        problem.setAlignmentX(Component.CENTER_ALIGNMENT);
        answer = new JTextField();
        centerPanel.add(problem);
        centerPanel.add(answer);
        bottomPanel= new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));
        submitAnswer = new JButton("Submit Answer");
        submitAnswer.setAlignmentX(Component.CENTER_ALIGNMENT);
        bottomPanel.add(submitAnswer);
        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(centerPanel, BorderLayout.CENTER);
        panel.add(bottomPanel, BorderLayout.SOUTH);

        pack();
    }

}
