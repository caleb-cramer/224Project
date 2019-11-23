import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class DivisionPanel extends JPanel {
    int padding = 4;

    JTextField divisor;
    JTextField dividend;
    JTextField quotient;

    public DivisionPanel() {
        //setLayout(new GridLayout(2, 2));
        setLayout(new GridBagLayout());

        int textFieldCols = 3;
        quotient = new JTextField(textFieldCols);
        quotient.setText("6");
        divisor = new JTextField(textFieldCols);
        divisor.setEditable(false);
        divisor.setText("4");
        dividend = new JTextField(textFieldCols);
        dividend.setEditable(false);
        dividend.setText("24");

        //quotient
        GridBagConstraints c1 = new GridBagConstraints();
        c1.gridx = 0;
        c1.gridy = 0;
        c1.gridwidth = 2;
        c1.anchor = GridBagConstraints.LINE_END;
        c1.insets = new Insets(0,0, padding * 2,0);  // padding
        add(quotient, c1);

        //divisor
        GridBagConstraints c2 = new GridBagConstraints();
        c2.gridx = 0;
        c2.gridy = 1;
        c2.gridwidth = 1;
        c2.insets = new Insets(0, 0, 0, padding * 2);  // padding
        add(divisor, c2);

        //dividend
        GridBagConstraints c3 = new GridBagConstraints();
        c3.gridx = 1;
        c3.gridy = 1;
        c3.gridwidth = 1;
        add(dividend, c3);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(8));

        int cornerX = dividend.getX() - padding;
        int cornerY = dividend.getY() - padding;
        g2.draw(new Line2D.Double(cornerX, cornerY, cornerX, cornerY + dividend.getHeight())); // vertical
        g2.draw(new Line2D.Double(cornerX, cornerY, cornerX + dividend.getWidth(), cornerY)); // horizontal

    }
}
