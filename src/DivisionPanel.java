import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class DivisionPanel extends JPanel {
    private int padding = 8;

    JTextField divisor;
    JTextField dividend;
    JTextField quotient;

    public DivisionPanel() {
        //setLayout(new GridLayout(2, 2));
        setLayout(new GridBagLayout());

        setupTextFields();

        //quotient
        GridBagConstraints c1 = new GridBagConstraints();
        c1.gridx = 0;
        c1.gridy = 0;
        c1.gridwidth = 2;
        c1.anchor = GridBagConstraints.LINE_END;
        c1.ipadx = 100;
        c1.ipady = 30;
        c1.insets = new Insets(0,0, padding * 2,0);  // padding
        this.add(quotient, c1);

        //divisor
        GridBagConstraints c2 = new GridBagConstraints();
        c2.gridx = 0;
        c2.gridy = 1;
        c2.gridwidth = 1;
        c2.ipadx = 100;
        c2.ipady = 30;
        c2.insets = new Insets(0, 0, 0, padding * 2);  // padding
        this.add(divisor, c2);

        //dividend
        GridBagConstraints c3 = new GridBagConstraints();
        c3.gridx = 1;
        c3.gridy = 1;
        c3.gridwidth = 1;
        c3.ipadx = 100;
        c3.ipady = 30;
        this.add(dividend, c3);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(16));

        int cornerX = dividend.getX() - padding;
        int cornerY = dividend.getY() - padding;
        g2.draw(new Line2D.Double(cornerX, cornerY, cornerX, cornerY + dividend.getHeight())); // vertical
        g2.draw(new Line2D.Double(cornerX, cornerY, cornerX + dividend.getWidth(), cornerY)); // horizontal

    }
<<<<<<< HEAD


>>>>>>> 2ad002338764241f3abd8bfeff43d58f8df7f1b0
    private void setupTextFields(){
        int textFieldCols = 3;

        Font myFont = new Font("Times Roman", Font.BOLD,50);

        quotient = new JTextField(textFieldCols);
        quotient.setFont(myFont);
        quotient.setHorizontalAlignment(JTextField.CENTER);
        quotient.setText("6");

        divisor = new JTextField(textFieldCols);
        divisor.setEditable(false);
        divisor.setFont(myFont);
        divisor.setHorizontalAlignment(JTextField.CENTER);
        divisor.setText("4");

        dividend = new JTextField(textFieldCols);
        dividend.setEditable(false);
        dividend.setFont(myFont);
        dividend.setHorizontalAlignment(JTextField.CENTER);
        dividend.setText("24");
    }
}