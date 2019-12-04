import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController {
    public LoginController(LoginPanel loginPanel){
        loginPanel.loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (loginPanel.usernameField.getText().equals("Caleb")){
                    loginPanel.statusLabel.setText("Hello " + loginPanel.usernameField.getText());
                }
            }
        });
    }
}
