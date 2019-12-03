import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PracticeController {
    protected PracticePanel view;

    public PracticeController(PracticePanel view) {
        this.view = view;

        view.submitAnswer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String dividendS = view.problem.dividend.getText();
                int dividendC = Integer.parseInt(dividendS);
                String divisorS = view.problem.divisor.getText();
                int divisorC = Integer.parseInt(divisorS);
                String quotientS = view.problem.quotient.getText();
                int quotientC = Integer.parseInt(quotientS);
                System.out.println(quotientC);
                System.out.println(dividendC);
                System.out.println(divisorC);
                if (dividendC == (quotientC * divisorC)) {
                    System.out.println("first if");
                    String[] options = {"Back to tutorial.",
                            "More practice.",
                            "Quiz myself."};
                    int choice = JOptionPane.showOptionDialog(view,
                            "You're answer is correct!",
                            "CORRECT",
                            JOptionPane.YES_NO_CANCEL_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            options,
                            options[2]);
                    if (choice == JOptionPane.YES_OPTION) {
                        System.out.println("yes");
                    }
                    else if (choice == JOptionPane.NO_OPTION) {
                        System.out.println("no");
                    }
                }
            }
        });
    }
}
