import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class LoginPanel extends JPanel {
    JLabel usernameLabel = new JLabel("Username:");
    JTextField usernameField;
    JLabel statusLabel;
    JButton loginButton;
    JLabel welcomeText = new JLabel("Welcome to DIVDR. \n" +
            "Whether you have worked with us before or not, " +
            "enter your username in the field below and we will get you all set up!");

    public LoginPanel() {
        super(new GridLayout(3,1));

        usernameField = new JTextField();
        JPanel firstPanel = new JPanel(new GridLayout(1,2));
        firstPanel.add(usernameLabel);
        firstPanel.add(usernameField);

        statusLabel = new JLabel("");
        loginButton = new JButton("Login");
        JPanel secondPanel =new JPanel();
        secondPanel.setLayout(new BoxLayout(secondPanel, BoxLayout.X_AXIS));
        secondPanel.add(loginButton);
        secondPanel.add(statusLabel);

        this.add(welcomeText);
        this.add(firstPanel);
        this.add(secondPanel);

        LoginController lc = new LoginController(this);
    }
}
