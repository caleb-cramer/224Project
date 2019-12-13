/**
 * This sets up the Practice Problem tab. There are instructions at the top
 * of the panel and the problem number. A division problem is located in the middle
 * page for the user to solve.
 * CPSC 224-01, Fall 2019
 * 224 Project
 * No sources to cite.
 *
 * @author Allison Hayes
 * @version v1.0 12/12/19
 */
import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class PracticePanel extends JPanel {

    //fields
    protected JPanel instructionPanel;
    protected JPanel problemPanel;
    protected JPanel topPanel;
    protected JPanel centerPanel;
    protected JPanel bottomPanel;
    protected JLabel problemNumber;
    protected JLabel instructions;
    protected DivisionPanel problem;
    protected JButton submitAnswer;
    protected PracticeController controller;
    private Random rand = new Random();

    /**
     * Constructor for PracticePanel.
     * Calls JPanel constructor and puts all GUI
     * components in place.
     */
    public PracticePanel() {
        super(new BorderLayout());

        instructionPanel = new JPanel();
        instructionPanel.setLayout(new BoxLayout(instructionPanel, BoxLayout.Y_AXIS));

        instructions = new JLabel("<html> <div align \"left\"> Welcome to the Practice Problem tab! <br/> <br/> Here, you can practice " +
                "your division skills. Below is a problem, solve it (using scratch paper if necessary), " +
                "then you can pick to return to the Tutorial tab, do more practice problems, or move on to " +
                "the Quiz tab. <br/> <br/> Good luck! <div/> <br/> </html>");
        instructions.setFont(new Font("Cailbri", Font.PLAIN, 14 ));
        instructions.setAlignmentX(Component.LEFT_ALIGNMENT);
        instructionPanel.add(instructions);

        problemPanel = new JPanel();
        problemPanel.setLayout(new BoxLayout(problemPanel, BoxLayout.Y_AXIS));

        problemNumber = new JLabel( "Problem 1");
        problemNumber.setFont(new Font("Cailbri", Font.BOLD, 18));
        problemPanel.add(problemNumber);

        topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.add(instructionPanel);
        topPanel.add(problemPanel);

        centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        problem = new DivisionPanel();
        problem.setAlignmentX(Component.CENTER_ALIGNMENT);
        problem = genProblem();
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
        controller = new PracticeController(this);
    }

    /**
     * Randomly generates numbers for a new division problem.
     * @return a DivisionPanel with s new problem.
     */
    private DivisionPanel genProblem(){
        int divisor = rand.nextInt(30) + 2;
        int dividend = rand.nextInt(30) + 2;
        int quotient = dividend * divisor;

        return new DivisionPanel(divisor, quotient, dividend);
    }

    /**
     * Changes problem displayed on the Practice Panel.
     */
    void newProblem(){
        centerPanel.remove(problem);
        problem = genProblem();
        centerPanel.add(problem);
    }

}

