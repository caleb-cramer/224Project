import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController {
    AppModel ap;
    public LoginController(LoginPanel loginPanel){
        this.ap = new AppModel();
        loginPanel.loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Learner newGuy = AppModel.checkUsername(loginPanel.usernameField.getText());
                if ( newGuy == null){
                    ap.insertLearner(new Learner(loginPanel.usernameField.getText(), 0.0, 0.0));
                    loginPanel.statusLabel.setText("<html>  <center> Welcome " + loginPanel.usernameField.getText() +
                            "! </center> <br/> We set up a new account for you! " +
                            " <br/>Your high score is 0.00 and your last score is 0.00</html>");
                }
                else{
                    loginPanel.statusLabel.setText("<html>Welcome " + newGuy.getUserName() +
                            "! <br/> Your high score is " + newGuy.getHighScore() +
                            " and your last score was " + newGuy.getLastScore() + "</html>");
                }
            }
        });
    }
}
