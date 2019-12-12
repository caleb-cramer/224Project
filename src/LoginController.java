import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author calebcramer
 * This class handles all of the events for the login panel
 */

public class LoginController {
    /**
     * creates a controller
     * @param loginPanel: the panel which this controller runs
     * @param ap: how to send all of the data to the database
     */
    public LoginController(LoginPanel loginPanel, AppModel ap){
        // actionListener for the login button
        loginPanel.loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //check to see if user has entered a username into the JTextField

                if (loginPanel.usernameField.getText().equals("")) {
                    //they have not so we show an error dialog and make them try again
                    JOptionPane.showMessageDialog(null,
                            "Enter a username to continue!",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
                else {
                    //they entered something so we check to see if they have a record in the database already
                    Learner newGuy = AppModel.checkUsername(loginPanel.usernameField.getText());

                    if (newGuy == null) {
                        //we didn't find anyone so let's make them a new record
                        newGuy = new Learner(loginPanel.usernameField.getText(), 0.0, 0.0);
                        ap.insertLearner(newGuy);
                        loginPanel.statusLabel.setText("<html>  <center> Welcome " + loginPanel.usernameField.getText() +
                                "! </center> <br/> We set up a new account for you! " +
                                " <br/>Your high score is 0.00 and your last score is 0.00</html>");
                    } else {
                        //we found someone so let's grab their stats
                        loginPanel.statusLabel.setText("<html>Welcome " + newGuy.getUserName() +
                                "! <br/> Your high score is " + newGuy.getHighScore() +
                                " and your last score was " + newGuy.getLastScore() + "</html>");
                    }
                    loginPanel.loginButton.setEnabled(false);
                    CurrentUser.setCu(newGuy);
                    TabbedPanel.openTabs();
                }
            }
        });
    }
}
