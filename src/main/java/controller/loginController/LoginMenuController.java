package controller.loginController;

import model.toolClasses.Result;
import model.enums.loginMenu.ConfirmQuestions;

public class LoginMenuController{

    // register
    public static Result register(String username, String password, String passwordConfirm, String nickname, String email) {
        return new Result(true, "");
    }
    private static boolean isUsernameAlreadyUsed(String username) {return true;}
    private static boolean isUsernameValid(String username) {return true;}
    private static boolean isEmailValid(String email) {return true;}
    private static boolean isPasswordValid(String password) {return true;}
    private static boolean isPasswordStrong(String password) {return true;}
    private static boolean isPasswordConfirmed(String password, String confirmPassword) {return true;}
    private static String randomPasswordGenerator() {return null;}
    private static void setAnswerOfConfirmQuestion(String answer, ConfirmQuestions question) {}

    // login
    public static Result login(String username, String password) {return new Result(true, "")}
    // use the  <isUsernameAlreadyUsed> for check existence of username
    private static boolean isPasswordCorrect(String username, String password) {return true;}

    // forget password
    private static Result forgetPassword(String username) {return new Result(true, "");}
    // check existence of username by <isUsernameAlreadyUsed>
    private static boolean isAnswerCorrect(String username) {return true;}
}