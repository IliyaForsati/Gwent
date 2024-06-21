package view.OtherMenu;

import controller.loginController.LoginMenuController;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import model.enums.loginMenu.ConfirmQuestions;
import model.toolClasses.Result;
import view.HeadViewController;

import java.util.Scanner;

public class LoginMenu {
    // terminal method
    public static void run(Scanner scanner) {
        while (true) {
            // todo : foad
        }
    }


    // declare some fields for fxml file
    public TextField usernameTextField;
    public PasswordField passwordField;
    public TextField nicknameTextField;
    public AnchorPane passwordPane;
    public TextField emailTextField;
    public AnchorPane questionPane;
    public Label errorLabel;

    public void goToRegisterPage() {
        HeadViewController.changeScene("register page");
    }
    public void backToLoginPage() {
        HeadViewController.changeScene("login page");
    }

    // login
    public void login() {
        // get result
        Result result = LoginMenuController.login(usernameTextField.getText(), passwordField.getText());

        // check error
        if (!result.isSuccessful()) {
            errorLabel.setText(result.getMessage());

            // use Timeline to delete massage after 2 seconds
            Timeline timeline = new Timeline();
            timeline.setCycleCount(1);
            KeyFrame keyFrame = new KeyFrame(Duration.seconds(2), actionEvent -> errorLabel.setText(""));
            timeline.getKeyFrames().add(keyFrame);
            timeline.play();
            return;
        }

        // change scene to mane scene
        HeadViewController.changeScene("main page");


    }

    public void forgetPassword() {
        // todo:
    }

    // register method
    public void register() {
        // declare a var to get access of user some variable in lambda
        var ref = new Object() {
            Result result;
            String password, confirmPassword;
        };
        String username, email, nickname;
        
        // get username, nickname ,and email
        username = usernameTextField.getText();
        nickname = nicknameTextField.getText();
        email = emailTextField.getText();
        
        // show password pane
        passwordPane.setVisible(true);
        

        
        ((Button) passwordPane.getChildren().get(4)).setOnMouseClicked(event -> {
            // set visible false for passwordPane
            passwordPane.setVisible(false);

            // get password ,and confirm password
            ref.password = ((TextField) passwordPane.getChildren().get(0)).getText();
            ref.confirmPassword = ((TextField) passwordPane.getChildren().get(1)).getText();

            ref.result = LoginMenuController.checkAllErrors
                    (username, ref.password, ref.confirmPassword, nickname, email);


            if (!ref.result.isSuccessful()) {
                // show error in a label with color RED
                errorLabel.setText(ref.result.getMessage());

                // use Timeline to delete massage after 2 seconds
                Timeline timeline = new Timeline();
                timeline.setCycleCount(1);
                KeyFrame keyFrame = new KeyFrame(Duration.seconds(2), actionEvent -> errorLabel.setText(""));
                timeline.getKeyFrames().add(keyFrame);
                timeline.play();

                // clear textFields and passwordFields
                ((TextField) passwordPane.getChildren().get(0)).setText("");
                ((TextField) passwordPane.getChildren().get(1)).setText("");
                usernameTextField.setText("");
                nicknameTextField.setText("");
                emailTextField.setText("");

                return;
            }

            // show question page
            questionPane.setVisible(true);

            var ref2 = new Object() {
                ConfirmQuestions confirmQuestions;
                String answer;
            };

            // for all buttons that I declare in fxml we must set text -> <question> and setOnMouthClick for all
            for (int i = 1; i <= 5; i++) {
                // get button no.i
                Button button = ((Button) questionPane.getChildren().get(i));
                // set text
                button.setText(ConfirmQuestions.valueOf("q" + i).getQuestion());

                // declare x to use that in lambda
                int x = i;
                button.setOnMouseClicked(event2 -> {
                    // get ConfirmQuestion
                    ref2.confirmQuestions = ConfirmQuestions.valueOf("q" + x);
                    AnchorPane pane = (AnchorPane) questionPane.getChildren().get(6);
                    // show textArea
                    pane.setVisible(true);
                    TextArea textArea = (TextArea) pane.getChildren().get(0);
                    // set prompt text of textArea --> question
                    textArea.setPromptText(ConfirmQuestions.valueOf("q" + x).getQuestion());
                    pane.getChildren().get(1).setOnMouseClicked(event3 -> {
                        // set questionPane invisible
                        questionPane.setVisible(false);
                        ref2.answer = textArea.getText();

                        // clear textFields and passwordFields
                        ((TextField) passwordPane.getChildren().get(0)).setText("");
                        ((TextField) passwordPane.getChildren().get(1)).setText("");
                        usernameTextField.setText("");
                        nicknameTextField.setText("");
                        emailTextField.setText("");
                        textArea.setText("");
                    });
                });
            }

            // now we sure that register can successful, so we call method registerNewUser in LoginMEnuController
            LoginMenuController.registerNewUser
                    (ref2.confirmQuestions, username, ref.password, nickname, email, ref2.answer);
        });
    }

    public void mute() {
        HeadViewController.player.setMute(HeadViewController.isMute = !HeadViewController.isMute);
    }
}