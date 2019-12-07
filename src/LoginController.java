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
                    loginPanel.statusLabel.setText("Welcome " + loginPanel.usernameField.getText() +
                            "! We set up a new account for you! " +
                            "Your high score is 0.00 and your last score is 0.00");
                }
                else{
                    loginPanel.statusLabel.setText("Welcome " + newGuy.getUserName() +
                            "! Your high score is " + newGuy.getHighScore() +
                            " and your last score was " + newGuy.getLastScore());
                }
            }
        });
    }
}
